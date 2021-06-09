package com.javaSchool.eCare.model.dto.user;

import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.UserEntity;
import com.javaSchool.eCare.model.entity.enums.Role;
import com.javaSchool.eCare.model.entity.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserAccountForm {

    private int id;
    private String fullname;
    private String email;
    private String date;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String passport;
    private String address;
    private Boolean blocked;
    private Boolean blocked_by_admin;
    private Set<Contract> contracts;
    private String contract_number;
    private Status status;
    private Role role;


    public UserAccountForm(UserEntity user) {
        this.id = user.getIdUser();
        this.fullname = user.getName().concat(" ").concat(user.getSurname());
        this.email = user.getEmail();
        this.status = user.getStatus();
        this.role = user.getRole();
        this.date = dateFormat.format(user.getBirth());
        this.passport = user.getPassport();
        this.contracts = user.getContract();
        this.address = user.getAddress();
    }

    public UserEntity toUserEntity() throws ParseException {
    UserEntity userEntity = new UserEntity();
    userEntity.setIdUser(this.id);
    userEntity.setName(this.fullname.split("\\s")[0]);
    userEntity.setSurname(this.fullname.split("\\s")[1]);
    userEntity.setBirth(this.dateFormat.parse(this.date));
    userEntity.setPassport(this.passport);
    userEntity.setAddress(this.address);
    userEntity.setEmail(this.email);
    userEntity.setRole(this.role);
    userEntity.setStatus(this.status);
    return userEntity;
    }

}
