package com.example.kechaval.appgym.api.reponse;

/**
 * Created by Aden on 13/11/2017.
 */

public class VerificationSheetResponse {

 public String AddressLong,Departament,DocDate,District,Latitude,Longitude,Name1,Name2,Province;
 public int DocID,DocState,Number;

    public String getAddressLong() {
        return AddressLong;
    }

    public void setAddressLong(String addressLong) {
        AddressLong = addressLong;
    }

    public String getDepartament() {
        return Departament;
    }

    public void setDepartament(String departament) {
        Departament = departament;
    }

    public String getDocDate() {
        return DocDate;
    }

    public void setDocDate(String docDate) {
        DocDate = docDate;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }

    public String getName2() {
        return Name2;
    }

    public void setName2(String name2) {
        Name2 = name2;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public int getDocID() {
        return DocID;
    }

    public void setDocID(int docID) {
        DocID = docID;
    }

    public int getDocState() {
        return DocState;
    }

    public void setDocState(int docState) {
        DocState = docState;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
}
