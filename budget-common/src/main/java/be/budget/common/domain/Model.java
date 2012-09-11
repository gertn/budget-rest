package be.budget.common.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Model implements Serializable {
	
	@Id
    @GeneratedValue
    public Long id;

    public Long getId() {
        return id;
    }

}
