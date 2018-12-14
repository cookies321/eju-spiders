package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnjukeCommunityDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnjukeCommunityDetailExample() {
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

        public Criteria andFangIdIsNull() {
            addCriterion("fang_id is null");
            return (Criteria) this;
        }

        public Criteria andFangIdIsNotNull() {
            addCriterion("fang_id is not null");
            return (Criteria) this;
        }

        public Criteria andFangIdEqualTo(String value) {
            addCriterion("fang_id =", value, "fangId");
            return (Criteria) this;
        }

        public Criteria andFangIdNotEqualTo(String value) {
            addCriterion("fang_id <>", value, "fangId");
            return (Criteria) this;
        }

        public Criteria andFangIdGreaterThan(String value) {
            addCriterion("fang_id >", value, "fangId");
            return (Criteria) this;
        }

        public Criteria andFangIdGreaterThanOrEqualTo(String value) {
            addCriterion("fang_id >=", value, "fangId");
            return (Criteria) this;
        }

        public Criteria andFangIdLessThan(String value) {
            addCriterion("fang_id <", value, "fangId");
            return (Criteria) this;
        }

        public Criteria andFangIdLessThanOrEqualTo(String value) {
            addCriterion("fang_id <=", value, "fangId");
            return (Criteria) this;
        }

        public Criteria andFangIdLike(String value) {
            addCriterion("fang_id like", value, "fangId");
            return (Criteria) this;
        }

        public Criteria andFangIdNotLike(String value) {
            addCriterion("fang_id not like", value, "fangId");
            return (Criteria) this;
        }

        public Criteria andFangIdIn(List<String> values) {
            addCriterion("fang_id in", values, "fangId");
            return (Criteria) this;
        }

        public Criteria andFangIdNotIn(List<String> values) {
            addCriterion("fang_id not in", values, "fangId");
            return (Criteria) this;
        }

        public Criteria andFangIdBetween(String value1, String value2) {
            addCriterion("fang_id between", value1, value2, "fangId");
            return (Criteria) this;
        }

        public Criteria andFangIdNotBetween(String value1, String value2) {
            addCriterion("fang_id not between", value1, value2, "fangId");
            return (Criteria) this;
        }

        public Criteria andHomeNameIsNull() {
            addCriterion("home_name is null");
            return (Criteria) this;
        }

        public Criteria andHomeNameIsNotNull() {
            addCriterion("home_name is not null");
            return (Criteria) this;
        }

        public Criteria andHomeNameEqualTo(String value) {
            addCriterion("home_name =", value, "homeName");
            return (Criteria) this;
        }

        public Criteria andHomeNameNotEqualTo(String value) {
            addCriterion("home_name <>", value, "homeName");
            return (Criteria) this;
        }

        public Criteria andHomeNameGreaterThan(String value) {
            addCriterion("home_name >", value, "homeName");
            return (Criteria) this;
        }

        public Criteria andHomeNameGreaterThanOrEqualTo(String value) {
            addCriterion("home_name >=", value, "homeName");
            return (Criteria) this;
        }

        public Criteria andHomeNameLessThan(String value) {
            addCriterion("home_name <", value, "homeName");
            return (Criteria) this;
        }

        public Criteria andHomeNameLessThanOrEqualTo(String value) {
            addCriterion("home_name <=", value, "homeName");
            return (Criteria) this;
        }

        public Criteria andHomeNameLike(String value) {
            addCriterion("home_name like", value, "homeName");
            return (Criteria) this;
        }

        public Criteria andHomeNameNotLike(String value) {
            addCriterion("home_name not like", value, "homeName");
            return (Criteria) this;
        }

        public Criteria andHomeNameIn(List<String> values) {
            addCriterion("home_name in", values, "homeName");
            return (Criteria) this;
        }

        public Criteria andHomeNameNotIn(List<String> values) {
            addCriterion("home_name not in", values, "homeName");
            return (Criteria) this;
        }

        public Criteria andHomeNameBetween(String value1, String value2) {
            addCriterion("home_name between", value1, value2, "homeName");
            return (Criteria) this;
        }

        public Criteria andHomeNameNotBetween(String value1, String value2) {
            addCriterion("home_name not between", value1, value2, "homeName");
            return (Criteria) this;
        }

        public Criteria andDetailUrlIsNull() {
            addCriterion("detail_url is null");
            return (Criteria) this;
        }

        public Criteria andDetailUrlIsNotNull() {
            addCriterion("detail_url is not null");
            return (Criteria) this;
        }

        public Criteria andDetailUrlEqualTo(String value) {
            addCriterion("detail_url =", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotEqualTo(String value) {
            addCriterion("detail_url <>", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlGreaterThan(String value) {
            addCriterion("detail_url >", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlGreaterThanOrEqualTo(String value) {
            addCriterion("detail_url >=", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlLessThan(String value) {
            addCriterion("detail_url <", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlLessThanOrEqualTo(String value) {
            addCriterion("detail_url <=", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlLike(String value) {
            addCriterion("detail_url like", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotLike(String value) {
            addCriterion("detail_url not like", value, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlIn(List<String> values) {
            addCriterion("detail_url in", values, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotIn(List<String> values) {
            addCriterion("detail_url not in", values, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlBetween(String value1, String value2) {
            addCriterion("detail_url between", value1, value2, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andDetailUrlNotBetween(String value1, String value2) {
            addCriterion("detail_url not between", value1, value2, "detailUrl");
            return (Criteria) this;
        }

        public Criteria andHomeTotalIsNull() {
            addCriterion("home_total is null");
            return (Criteria) this;
        }

        public Criteria andHomeTotalIsNotNull() {
            addCriterion("home_total is not null");
            return (Criteria) this;
        }

        public Criteria andHomeTotalEqualTo(String value) {
            addCriterion("home_total =", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalNotEqualTo(String value) {
            addCriterion("home_total <>", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalGreaterThan(String value) {
            addCriterion("home_total >", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalGreaterThanOrEqualTo(String value) {
            addCriterion("home_total >=", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalLessThan(String value) {
            addCriterion("home_total <", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalLessThanOrEqualTo(String value) {
            addCriterion("home_total <=", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalLike(String value) {
            addCriterion("home_total like", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalNotLike(String value) {
            addCriterion("home_total not like", value, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalIn(List<String> values) {
            addCriterion("home_total in", values, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalNotIn(List<String> values) {
            addCriterion("home_total not in", values, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalBetween(String value1, String value2) {
            addCriterion("home_total between", value1, value2, "homeTotal");
            return (Criteria) this;
        }

        public Criteria andHomeTotalNotBetween(String value1, String value2) {
            addCriterion("home_total not between", value1, value2, "homeTotal");
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

        public Criteria andBuildAreaIsNull() {
            addCriterion("build_area is null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIsNotNull() {
            addCriterion("build_area is not null");
            return (Criteria) this;
        }

        public Criteria andBuildAreaEqualTo(String value) {
            addCriterion("build_area =", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotEqualTo(String value) {
            addCriterion("build_area <>", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThan(String value) {
            addCriterion("build_area >", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaGreaterThanOrEqualTo(String value) {
            addCriterion("build_area >=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThan(String value) {
            addCriterion("build_area <", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLessThanOrEqualTo(String value) {
            addCriterion("build_area <=", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaLike(String value) {
            addCriterion("build_area like", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotLike(String value) {
            addCriterion("build_area not like", value, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaIn(List<String> values) {
            addCriterion("build_area in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotIn(List<String> values) {
            addCriterion("build_area not in", values, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaBetween(String value1, String value2) {
            addCriterion("build_area between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andBuildAreaNotBetween(String value1, String value2) {
            addCriterion("build_area not between", value1, value2, "buildArea");
            return (Criteria) this;
        }

        public Criteria andPlotRateIsNull() {
            addCriterion("plot_rate is null");
            return (Criteria) this;
        }

        public Criteria andPlotRateIsNotNull() {
            addCriterion("plot_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPlotRateEqualTo(String value) {
            addCriterion("plot_rate =", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateNotEqualTo(String value) {
            addCriterion("plot_rate <>", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateGreaterThan(String value) {
            addCriterion("plot_rate >", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateGreaterThanOrEqualTo(String value) {
            addCriterion("plot_rate >=", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateLessThan(String value) {
            addCriterion("plot_rate <", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateLessThanOrEqualTo(String value) {
            addCriterion("plot_rate <=", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateLike(String value) {
            addCriterion("plot_rate like", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateNotLike(String value) {
            addCriterion("plot_rate not like", value, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateIn(List<String> values) {
            addCriterion("plot_rate in", values, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateNotIn(List<String> values) {
            addCriterion("plot_rate not in", values, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateBetween(String value1, String value2) {
            addCriterion("plot_rate between", value1, value2, "plotRate");
            return (Criteria) this;
        }

        public Criteria andPlotRateNotBetween(String value1, String value2) {
            addCriterion("plot_rate not between", value1, value2, "plotRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateIsNull() {
            addCriterion("green_rate is null");
            return (Criteria) this;
        }

        public Criteria andGreenRateIsNotNull() {
            addCriterion("green_rate is not null");
            return (Criteria) this;
        }

        public Criteria andGreenRateEqualTo(String value) {
            addCriterion("green_rate =", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateNotEqualTo(String value) {
            addCriterion("green_rate <>", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateGreaterThan(String value) {
            addCriterion("green_rate >", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateGreaterThanOrEqualTo(String value) {
            addCriterion("green_rate >=", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateLessThan(String value) {
            addCriterion("green_rate <", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateLessThanOrEqualTo(String value) {
            addCriterion("green_rate <=", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateLike(String value) {
            addCriterion("green_rate like", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateNotLike(String value) {
            addCriterion("green_rate not like", value, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateIn(List<String> values) {
            addCriterion("green_rate in", values, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateNotIn(List<String> values) {
            addCriterion("green_rate not in", values, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateBetween(String value1, String value2) {
            addCriterion("green_rate between", value1, value2, "greenRate");
            return (Criteria) this;
        }

        public Criteria andGreenRateNotBetween(String value1, String value2) {
            addCriterion("green_rate not between", value1, value2, "greenRate");
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

        public Criteria andPropertyPriceIsNull() {
            addCriterion("property_price is null");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceIsNotNull() {
            addCriterion("property_price is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceEqualTo(String value) {
            addCriterion("property_price =", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotEqualTo(String value) {
            addCriterion("property_price <>", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceGreaterThan(String value) {
            addCriterion("property_price >", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceGreaterThanOrEqualTo(String value) {
            addCriterion("property_price >=", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceLessThan(String value) {
            addCriterion("property_price <", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceLessThanOrEqualTo(String value) {
            addCriterion("property_price <=", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceLike(String value) {
            addCriterion("property_price like", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotLike(String value) {
            addCriterion("property_price not like", value, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceIn(List<String> values) {
            addCriterion("property_price in", values, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotIn(List<String> values) {
            addCriterion("property_price not in", values, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceBetween(String value1, String value2) {
            addCriterion("property_price between", value1, value2, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andPropertyPriceNotBetween(String value1, String value2) {
            addCriterion("property_price not between", value1, value2, "propertyPrice");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolIsNull() {
            addCriterion("duikou_school is null");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolIsNotNull() {
            addCriterion("duikou_school is not null");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolEqualTo(String value) {
            addCriterion("duikou_school =", value, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolNotEqualTo(String value) {
            addCriterion("duikou_school <>", value, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolGreaterThan(String value) {
            addCriterion("duikou_school >", value, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("duikou_school >=", value, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolLessThan(String value) {
            addCriterion("duikou_school <", value, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolLessThanOrEqualTo(String value) {
            addCriterion("duikou_school <=", value, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolLike(String value) {
            addCriterion("duikou_school like", value, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolNotLike(String value) {
            addCriterion("duikou_school not like", value, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolIn(List<String> values) {
            addCriterion("duikou_school in", values, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolNotIn(List<String> values) {
            addCriterion("duikou_school not in", values, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolBetween(String value1, String value2) {
            addCriterion("duikou_school between", value1, value2, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andDuikouSchoolNotBetween(String value1, String value2) {
            addCriterion("duikou_school not between", value1, value2, "duikouSchool");
            return (Criteria) this;
        }

        public Criteria andParkNumIsNull() {
            addCriterion("park_num is null");
            return (Criteria) this;
        }

        public Criteria andParkNumIsNotNull() {
            addCriterion("park_num is not null");
            return (Criteria) this;
        }

        public Criteria andParkNumEqualTo(String value) {
            addCriterion("park_num =", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumNotEqualTo(String value) {
            addCriterion("park_num <>", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumGreaterThan(String value) {
            addCriterion("park_num >", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumGreaterThanOrEqualTo(String value) {
            addCriterion("park_num >=", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumLessThan(String value) {
            addCriterion("park_num <", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumLessThanOrEqualTo(String value) {
            addCriterion("park_num <=", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumLike(String value) {
            addCriterion("park_num like", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumNotLike(String value) {
            addCriterion("park_num not like", value, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumIn(List<String> values) {
            addCriterion("park_num in", values, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumNotIn(List<String> values) {
            addCriterion("park_num not in", values, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumBetween(String value1, String value2) {
            addCriterion("park_num between", value1, value2, "parkNum");
            return (Criteria) this;
        }

        public Criteria andParkNumNotBetween(String value1, String value2) {
            addCriterion("park_num not between", value1, value2, "parkNum");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlIsNull() {
            addCriterion("layout_url is null");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlIsNotNull() {
            addCriterion("layout_url is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlEqualTo(String value) {
            addCriterion("layout_url =", value, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlNotEqualTo(String value) {
            addCriterion("layout_url <>", value, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlGreaterThan(String value) {
            addCriterion("layout_url >", value, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlGreaterThanOrEqualTo(String value) {
            addCriterion("layout_url >=", value, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlLessThan(String value) {
            addCriterion("layout_url <", value, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlLessThanOrEqualTo(String value) {
            addCriterion("layout_url <=", value, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlLike(String value) {
            addCriterion("layout_url like", value, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlNotLike(String value) {
            addCriterion("layout_url not like", value, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlIn(List<String> values) {
            addCriterion("layout_url in", values, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlNotIn(List<String> values) {
            addCriterion("layout_url not in", values, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlBetween(String value1, String value2) {
            addCriterion("layout_url between", value1, value2, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andLayoutUrlNotBetween(String value1, String value2) {
            addCriterion("layout_url not between", value1, value2, "layoutUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlIsNull() {
            addCriterion("reality_url is null");
            return (Criteria) this;
        }

        public Criteria andRealityUrlIsNotNull() {
            addCriterion("reality_url is not null");
            return (Criteria) this;
        }

        public Criteria andRealityUrlEqualTo(String value) {
            addCriterion("reality_url =", value, "realityUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlNotEqualTo(String value) {
            addCriterion("reality_url <>", value, "realityUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlGreaterThan(String value) {
            addCriterion("reality_url >", value, "realityUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlGreaterThanOrEqualTo(String value) {
            addCriterion("reality_url >=", value, "realityUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlLessThan(String value) {
            addCriterion("reality_url <", value, "realityUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlLessThanOrEqualTo(String value) {
            addCriterion("reality_url <=", value, "realityUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlLike(String value) {
            addCriterion("reality_url like", value, "realityUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlNotLike(String value) {
            addCriterion("reality_url not like", value, "realityUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlIn(List<String> values) {
            addCriterion("reality_url in", values, "realityUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlNotIn(List<String> values) {
            addCriterion("reality_url not in", values, "realityUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlBetween(String value1, String value2) {
            addCriterion("reality_url between", value1, value2, "realityUrl");
            return (Criteria) this;
        }

        public Criteria andRealityUrlNotBetween(String value1, String value2) {
            addCriterion("reality_url not between", value1, value2, "realityUrl");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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