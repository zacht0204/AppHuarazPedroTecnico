
package com.huaraz.luis.apphuarazTecnico.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Search {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("lost_pet_id")
    @Expose
    private Integer lostPetId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("state")
    @Expose
    private Integer state;
    @SerializedName("lost_pet")
    @Expose
    private PetLost lostPet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLostPetId() {
        return lostPetId;
    }

    public void setLostPetId(Integer lostPetId) {
        this.lostPetId = lostPetId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public PetLost getLostPet() {
        return lostPet;
    }

    public void setLostPet(PetLost lostPet) {
        this.lostPet = lostPet;
    }

}
