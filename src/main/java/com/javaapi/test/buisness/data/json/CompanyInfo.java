package com.javaapi.test.buisness.data.json;

import java.util.List;
import java.util.Map;

public class CompanyInfo {
  private CompanyName       company;
  private String            companyType;
  private String            companyName;
  private Map               map;
  private List              list;
  private List<CompanyName> listCompanyName;

  public List<CompanyName> getListCompanyName() {
    return listCompanyName;
  }

  public void setListCompanyName(List<CompanyName> listCompanyName) {
    this.listCompanyName = listCompanyName;
  }

  public CompanyName getCompany() {
    return company;
  }

  public void setCompany(CompanyName company) {
    this.company = company;
  }

  public String getCompanyType() {
    return companyType;
  }

  public void setCompanyType(String companyType) {
    this.companyType = companyType;
  }

  public Map getMap() {
    return map;
  }

  public void setMap(Map map) {
    this.map = map;
  }

  public List getList() {
    return list;
  }

  public void setList(List list) {
    this.list = list;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

}