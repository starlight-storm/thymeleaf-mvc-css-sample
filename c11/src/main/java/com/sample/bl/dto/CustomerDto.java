package com.sample.bl.dto;

import javax.validation.constraints.AssertFalse;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class CustomerDto implements java.io.Serializable {
	
	private int id;

    @NotBlank
    @Length(max = 20)
    private String name;

    @NotBlank
    @Length(max = 100)
    private String address;

    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    private String membershipType;
    
    @NotBlank
    private String graduate;

    public CustomerDto() {
    }
    
    public CustomerDto(String name, String address, String email, String membershipType, String graduate) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.membershipType = membershipType;
        this.graduate = graduate;
    }

    @AssertFalse(message = "{errors.ngemail}")
    public boolean isNgEmail() {
        // ドメイン名が「ng.foo.baz」であれば使用不可のアドレスと見なす
        return email.matches(".*@ng.foo.baz$");
    }
    
	private static final long serialVersionUID = 3428490997353904743L;
}
