package sample.customer.biz.domain;

import javax.validation.constraints.AssertFalse;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class Customer implements java.io.Serializable {
	
	private int id;

    @NotBlank
    @Length(max = 20)
    private String name;

    @NotBlank
    @Length(max = 100)
    private String address;

    @NotBlank
    @Email
    private String emailAddress;
    
    @NotBlank
    private String rank;
    
    @NotBlank
    private String sex;

    public Customer() {
    }
    
    public Customer(String name, String address, String emailAddress, String rank, String sex) {
        this.name = name;
        this.address = address;
        this.emailAddress = emailAddress;
        this.rank = rank;
        this.sex = sex;
    }

    @AssertFalse(message = "{errors.ngemail}")
    public boolean isNgEmail() {
        // ドメイン名が「ng.foo.baz」であれば使用不可のアドレスと見なす
        return emailAddress.matches(".*@ng.foo.baz$");
    }

    public boolean isFreeEmail() {
        // ドメイン名が「free.foo.baz」であればフリーメールのアドレスと見なす
    	return emailAddress.matches(".*@free.foo.baz$");
    }
	private static final long serialVersionUID = 3428490997353904743L;
}
