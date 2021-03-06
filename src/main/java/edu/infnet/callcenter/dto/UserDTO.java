package edu.infnet.callcenter.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String type;
    private Timestamp created_at;
    private Timestamp updated_at;

    public UserDTO() {

    }

    public UserDTO(String name, String cpf, String email, String type) {
        this.name = name;
        this.type = type;
        this.cpf = cpf;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

	@OneToMany(targetEntity=TicketDTO.class, mappedBy="users", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<TicketDTO> tickets = new ArrayList<>();

    public List<TicketDTO> getTickets() {
        return tickets;
    }
}
