
package com.huaraz.luis.apphuarazTecnico.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pet {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("vaccinated")
    @Expose
    private String vaccinated;
    @SerializedName("information")
    @Expose
    private String information;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("pet_type_id")
    @Expose
    private Integer petTypeId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("race_id")
    @Expose
    private Integer raceId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("photo_file_name")
    @Expose
    private String photoFileName;
    @SerializedName("photo_content_type")
    @Expose
    private String photoContentType;
    @SerializedName("photo_file_size")
    @Expose
    private Integer photoFileSize;
    @SerializedName("photo_updated_at")
    @Expose
    private String photoUpdatedAt;
    @SerializedName("picture")
    @Expose
    private String picture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(String vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(Integer petTypeId) {
        this.petTypeId = petTypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
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

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public Integer getPhotoFileSize() {
        return photoFileSize;
    }

    public void setPhotoFileSize(Integer photoFileSize) {
        this.photoFileSize = photoFileSize;
    }

    public String getPhotoUpdatedAt() {
        return photoUpdatedAt;
    }

    public void setPhotoUpdatedAt(String photoUpdatedAt) {
        this.photoUpdatedAt = photoUpdatedAt;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
