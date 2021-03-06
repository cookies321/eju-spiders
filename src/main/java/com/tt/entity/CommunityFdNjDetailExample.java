package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityFdNjDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityFdNjDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIdIsNull() {
            addCriterion("title_id is null");
            return (Criteria) this;
        }

        public Criteria andTitleIdIsNotNull() {
            addCriterion("title_id is not null");
            return (Criteria) this;
        }

        public Criteria andTitleIdEqualTo(String value) {
            addCriterion("title_id =", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotEqualTo(String value) {
            addCriterion("title_id <>", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThan(String value) {
            addCriterion("title_id >", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdGreaterThanOrEqualTo(String value) {
            addCriterion("title_id >=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThan(String value) {
            addCriterion("title_id <", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLessThanOrEqualTo(String value) {
            addCriterion("title_id <=", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdLike(String value) {
            addCriterion("title_id like", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotLike(String value) {
            addCriterion("title_id not like", value, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdIn(List<String> values) {
            addCriterion("title_id in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotIn(List<String> values) {
            addCriterion("title_id not in", values, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdBetween(String value1, String value2) {
            addCriterion("title_id between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andTitleIdNotBetween(String value1, String value2) {
            addCriterion("title_id not between", value1, value2, "titleId");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNull() {
            addCriterion("property_type is null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNotNull() {
            addCriterion("property_type is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeEqualTo(String value) {
            addCriterion("property_type =", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotEqualTo(String value) {
            addCriterion("property_type <>", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThan(String value) {
            addCriterion("property_type >", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("property_type >=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThan(String value) {
            addCriterion("property_type <", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThanOrEqualTo(String value) {
            addCriterion("property_type <=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLike(String value) {
            addCriterion("property_type like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotLike(String value) {
            addCriterion("property_type not like", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIn(List<String> values) {
            addCriterion("property_type in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotIn(List<String> values) {
            addCriterion("property_type not in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeBetween(String value1, String value2) {
            addCriterion("property_type between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotBetween(String value1, String value2) {
            addCriterion("property_type not between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersIsNull() {
            addCriterion("build_developers is null");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersIsNotNull() {
            addCriterion("build_developers is not null");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersEqualTo(String value) {
            addCriterion("build_developers =", value, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersNotEqualTo(String value) {
            addCriterion("build_developers <>", value, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersGreaterThan(String value) {
            addCriterion("build_developers >", value, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersGreaterThanOrEqualTo(String value) {
            addCriterion("build_developers >=", value, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersLessThan(String value) {
            addCriterion("build_developers <", value, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersLessThanOrEqualTo(String value) {
            addCriterion("build_developers <=", value, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersLike(String value) {
            addCriterion("build_developers like", value, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersNotLike(String value) {
            addCriterion("build_developers not like", value, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersIn(List<String> values) {
            addCriterion("build_developers in", values, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersNotIn(List<String> values) {
            addCriterion("build_developers not in", values, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersBetween(String value1, String value2) {
            addCriterion("build_developers between", value1, value2, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andBuildDevelopersNotBetween(String value1, String value2) {
            addCriterion("build_developers not between", value1, value2, "buildDevelopers");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyIsNull() {
            addCriterion("sales_company is null");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyIsNotNull() {
            addCriterion("sales_company is not null");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyEqualTo(String value) {
            addCriterion("sales_company =", value, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyNotEqualTo(String value) {
            addCriterion("sales_company <>", value, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyGreaterThan(String value) {
            addCriterion("sales_company >", value, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("sales_company >=", value, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyLessThan(String value) {
            addCriterion("sales_company <", value, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyLessThanOrEqualTo(String value) {
            addCriterion("sales_company <=", value, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyLike(String value) {
            addCriterion("sales_company like", value, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyNotLike(String value) {
            addCriterion("sales_company not like", value, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyIn(List<String> values) {
            addCriterion("sales_company in", values, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyNotIn(List<String> values) {
            addCriterion("sales_company not in", values, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyBetween(String value1, String value2) {
            addCriterion("sales_company between", value1, value2, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andSalesCompanyNotBetween(String value1, String value2) {
            addCriterion("sales_company not between", value1, value2, "salesCompany");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeIsNull() {
            addCriterion("new_open_time is null");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeIsNotNull() {
            addCriterion("new_open_time is not null");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeEqualTo(String value) {
            addCriterion("new_open_time =", value, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeNotEqualTo(String value) {
            addCriterion("new_open_time <>", value, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeGreaterThan(String value) {
            addCriterion("new_open_time >", value, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeGreaterThanOrEqualTo(String value) {
            addCriterion("new_open_time >=", value, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeLessThan(String value) {
            addCriterion("new_open_time <", value, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeLessThanOrEqualTo(String value) {
            addCriterion("new_open_time <=", value, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeLike(String value) {
            addCriterion("new_open_time like", value, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeNotLike(String value) {
            addCriterion("new_open_time not like", value, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeIn(List<String> values) {
            addCriterion("new_open_time in", values, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeNotIn(List<String> values) {
            addCriterion("new_open_time not in", values, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeBetween(String value1, String value2) {
            addCriterion("new_open_time between", value1, value2, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andNewOpenTimeNotBetween(String value1, String value2) {
            addCriterion("new_open_time not between", value1, value2, "newOpenTime");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitIsNull() {
            addCriterion("pre_sale_permit is null");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitIsNotNull() {
            addCriterion("pre_sale_permit is not null");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitEqualTo(String value) {
            addCriterion("pre_sale_permit =", value, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitNotEqualTo(String value) {
            addCriterion("pre_sale_permit <>", value, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitGreaterThan(String value) {
            addCriterion("pre_sale_permit >", value, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitGreaterThanOrEqualTo(String value) {
            addCriterion("pre_sale_permit >=", value, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitLessThan(String value) {
            addCriterion("pre_sale_permit <", value, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitLessThanOrEqualTo(String value) {
            addCriterion("pre_sale_permit <=", value, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitLike(String value) {
            addCriterion("pre_sale_permit like", value, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitNotLike(String value) {
            addCriterion("pre_sale_permit not like", value, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitIn(List<String> values) {
            addCriterion("pre_sale_permit in", values, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitNotIn(List<String> values) {
            addCriterion("pre_sale_permit not in", values, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitBetween(String value1, String value2) {
            addCriterion("pre_sale_permit between", value1, value2, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andPreSalePermitNotBetween(String value1, String value2) {
            addCriterion("pre_sale_permit not between", value1, value2, "preSalePermit");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateIsNull() {
            addCriterion("land_property_certificate is null");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateIsNotNull() {
            addCriterion("land_property_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateEqualTo(String value) {
            addCriterion("land_property_certificate =", value, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateNotEqualTo(String value) {
            addCriterion("land_property_certificate <>", value, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateGreaterThan(String value) {
            addCriterion("land_property_certificate >", value, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("land_property_certificate >=", value, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateLessThan(String value) {
            addCriterion("land_property_certificate <", value, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateLessThanOrEqualTo(String value) {
            addCriterion("land_property_certificate <=", value, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateLike(String value) {
            addCriterion("land_property_certificate like", value, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateNotLike(String value) {
            addCriterion("land_property_certificate not like", value, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateIn(List<String> values) {
            addCriterion("land_property_certificate in", values, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateNotIn(List<String> values) {
            addCriterion("land_property_certificate not in", values, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateBetween(String value1, String value2) {
            addCriterion("land_property_certificate between", value1, value2, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandPropertyCertificateNotBetween(String value1, String value2) {
            addCriterion("land_property_certificate not between", value1, value2, "landPropertyCertificate");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitIsNull() {
            addCriterion("land_use_permit is null");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitIsNotNull() {
            addCriterion("land_use_permit is not null");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitEqualTo(String value) {
            addCriterion("land_use_permit =", value, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitNotEqualTo(String value) {
            addCriterion("land_use_permit <>", value, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitGreaterThan(String value) {
            addCriterion("land_use_permit >", value, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitGreaterThanOrEqualTo(String value) {
            addCriterion("land_use_permit >=", value, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitLessThan(String value) {
            addCriterion("land_use_permit <", value, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitLessThanOrEqualTo(String value) {
            addCriterion("land_use_permit <=", value, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitLike(String value) {
            addCriterion("land_use_permit like", value, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitNotLike(String value) {
            addCriterion("land_use_permit not like", value, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitIn(List<String> values) {
            addCriterion("land_use_permit in", values, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitNotIn(List<String> values) {
            addCriterion("land_use_permit not in", values, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitBetween(String value1, String value2) {
            addCriterion("land_use_permit between", value1, value2, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andLandUsePermitNotBetween(String value1, String value2) {
            addCriterion("land_use_permit not between", value1, value2, "landUsePermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitIsNull() {
            addCriterion("engineering_planning_permit is null");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitIsNotNull() {
            addCriterion("engineering_planning_permit is not null");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitEqualTo(String value) {
            addCriterion("engineering_planning_permit =", value, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitNotEqualTo(String value) {
            addCriterion("engineering_planning_permit <>", value, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitGreaterThan(String value) {
            addCriterion("engineering_planning_permit >", value, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitGreaterThanOrEqualTo(String value) {
            addCriterion("engineering_planning_permit >=", value, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitLessThan(String value) {
            addCriterion("engineering_planning_permit <", value, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitLessThanOrEqualTo(String value) {
            addCriterion("engineering_planning_permit <=", value, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitLike(String value) {
            addCriterion("engineering_planning_permit like", value, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitNotLike(String value) {
            addCriterion("engineering_planning_permit not like", value, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitIn(List<String> values) {
            addCriterion("engineering_planning_permit in", values, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitNotIn(List<String> values) {
            addCriterion("engineering_planning_permit not in", values, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitBetween(String value1, String value2) {
            addCriterion("engineering_planning_permit between", value1, value2, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andEngineeringPlanningPermitNotBetween(String value1, String value2) {
            addCriterion("engineering_planning_permit not between", value1, value2, "engineeringPlanningPermit");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceIsNull() {
            addCriterion("builder_licence is null");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceIsNotNull() {
            addCriterion("builder_licence is not null");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceEqualTo(String value) {
            addCriterion("builder_licence =", value, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceNotEqualTo(String value) {
            addCriterion("builder_licence <>", value, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceGreaterThan(String value) {
            addCriterion("builder_licence >", value, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceGreaterThanOrEqualTo(String value) {
            addCriterion("builder_licence >=", value, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceLessThan(String value) {
            addCriterion("builder_licence <", value, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceLessThanOrEqualTo(String value) {
            addCriterion("builder_licence <=", value, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceLike(String value) {
            addCriterion("builder_licence like", value, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceNotLike(String value) {
            addCriterion("builder_licence not like", value, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceIn(List<String> values) {
            addCriterion("builder_licence in", values, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceNotIn(List<String> values) {
            addCriterion("builder_licence not in", values, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceBetween(String value1, String value2) {
            addCriterion("builder_licence between", value1, value2, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andBuilderLicenceNotBetween(String value1, String value2) {
            addCriterion("builder_licence not between", value1, value2, "builderLicence");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyIsNull() {
            addCriterion("property_company is null");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyIsNotNull() {
            addCriterion("property_company is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyEqualTo(String value) {
            addCriterion("property_company =", value, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyNotEqualTo(String value) {
            addCriterion("property_company <>", value, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyGreaterThan(String value) {
            addCriterion("property_company >", value, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("property_company >=", value, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyLessThan(String value) {
            addCriterion("property_company <", value, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyLessThanOrEqualTo(String value) {
            addCriterion("property_company <=", value, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyLike(String value) {
            addCriterion("property_company like", value, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyNotLike(String value) {
            addCriterion("property_company not like", value, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyIn(List<String> values) {
            addCriterion("property_company in", values, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyNotIn(List<String> values) {
            addCriterion("property_company not in", values, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyBetween(String value1, String value2) {
            addCriterion("property_company between", value1, value2, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andPropertyCompanyNotBetween(String value1, String value2) {
            addCriterion("property_company not between", value1, value2, "propertyCompany");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlIsNull() {
            addCriterion("xiaoqu_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlIsNotNull() {
            addCriterion("xiaoqu_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlEqualTo(String value) {
            addCriterion("xiaoqu_photo_url =", value, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlNotEqualTo(String value) {
            addCriterion("xiaoqu_photo_url <>", value, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlGreaterThan(String value) {
            addCriterion("xiaoqu_photo_url >", value, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("xiaoqu_photo_url >=", value, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlLessThan(String value) {
            addCriterion("xiaoqu_photo_url <", value, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("xiaoqu_photo_url <=", value, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlLike(String value) {
            addCriterion("xiaoqu_photo_url like", value, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlNotLike(String value) {
            addCriterion("xiaoqu_photo_url not like", value, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlIn(List<String> values) {
            addCriterion("xiaoqu_photo_url in", values, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlNotIn(List<String> values) {
            addCriterion("xiaoqu_photo_url not in", values, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlBetween(String value1, String value2) {
            addCriterion("xiaoqu_photo_url between", value1, value2, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("xiaoqu_photo_url not between", value1, value2, "xiaoquPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlIsNull() {
            addCriterion("xiaoqu_layout_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlIsNotNull() {
            addCriterion("xiaoqu_layout_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlEqualTo(String value) {
            addCriterion("xiaoqu_layout_photo_url =", value, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlNotEqualTo(String value) {
            addCriterion("xiaoqu_layout_photo_url <>", value, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlGreaterThan(String value) {
            addCriterion("xiaoqu_layout_photo_url >", value, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("xiaoqu_layout_photo_url >=", value, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlLessThan(String value) {
            addCriterion("xiaoqu_layout_photo_url <", value, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("xiaoqu_layout_photo_url <=", value, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlLike(String value) {
            addCriterion("xiaoqu_layout_photo_url like", value, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlNotLike(String value) {
            addCriterion("xiaoqu_layout_photo_url not like", value, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlIn(List<String> values) {
            addCriterion("xiaoqu_layout_photo_url in", values, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlNotIn(List<String> values) {
            addCriterion("xiaoqu_layout_photo_url not in", values, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlBetween(String value1, String value2) {
            addCriterion("xiaoqu_layout_photo_url between", value1, value2, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquLayoutPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("xiaoqu_layout_photo_url not between", value1, value2, "xiaoquLayoutPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNull() {
            addCriterion("batch_id is null");
            return (Criteria) this;
        }

        public Criteria andBatchIdIsNotNull() {
            addCriterion("batch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBatchIdEqualTo(String value) {
            addCriterion("batch_id =", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotEqualTo(String value) {
            addCriterion("batch_id <>", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThan(String value) {
            addCriterion("batch_id >", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdGreaterThanOrEqualTo(String value) {
            addCriterion("batch_id >=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThan(String value) {
            addCriterion("batch_id <", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLessThanOrEqualTo(String value) {
            addCriterion("batch_id <=", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdLike(String value) {
            addCriterion("batch_id like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotLike(String value) {
            addCriterion("batch_id not like", value, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdIn(List<String> values) {
            addCriterion("batch_id in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotIn(List<String> values) {
            addCriterion("batch_id not in", values, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdBetween(String value1, String value2) {
            addCriterion("batch_id between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andBatchIdNotBetween(String value1, String value2) {
            addCriterion("batch_id not between", value1, value2, "batchId");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}