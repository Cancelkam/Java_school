package com.javaSchool.eCare.model.dto.contract;

import com.javaSchool.eCare.model.entity.Contract;
import com.javaSchool.eCare.model.entity.Option;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class ContractViewForm {
    private int idContract;
    private String number;
    private String tariff_title;
    private Boolean tariff_deprecated;
    private Double tariff_price;
    private int idTariff;
    private Set<Option> options;
    private String user_email;
    private boolean blocked;
    private boolean blocked_by_admin;

    public ContractViewForm(Contract contract){
        this.idContract=contract.getIdContract();
        this.number=contract.getNumber();
        this.tariff_title=contract.getTariff().getTitle();
        this.tariff_deprecated=contract.getTariff().isDeprecated();
        this.tariff_price = contract.getTariff().getPrice();
        this.idTariff = contract.getTariff().getIdTariff();
        this.user_email=contract.getUserEntity().getEmail();
        this.options = contract.getTariff().getOptionIdList();
        this.blocked=contract.isBlocked();
        this.blocked_by_admin=contract.isBlocked_by_admin();

    }
}

