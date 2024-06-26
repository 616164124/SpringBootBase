package com.mikael.web.demo.domain;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 
 * @TableName admin
 */
public class Admin implements Serializable {
    /**
     * 
     */
    private Long pokid;

    /**
     * 
     */
    @Size(max = 3,message = "太长")
    private String username;

    /**
     * 
     */
    private String password;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getPokid() {
        return pokid;
    }

    /**
     * 
     */
    public void setPokid(Long pokid) {
        this.pokid = pokid;
    }

    /**
     * 
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Admin other = (Admin) that;
        return (this.getPokid() == null ? other.getPokid() == null : this.getPokid().equals(other.getPokid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPokid() == null) ? 0 : getPokid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pokid=").append(pokid);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}