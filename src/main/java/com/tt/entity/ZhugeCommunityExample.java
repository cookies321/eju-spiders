package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZhugeCommunityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZhugeCommunityExample() {
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

        public Criteria andPlateIsNull() {
            addCriterion("plate is null");
            return (Criteria) this;
        }

        public Criteria andPlateIsNotNull() {
            addCriterion("plate is not null");
            return (Criteria) this;
        }

        public Criteria andPlateEqualTo(String value) {
            addCriterion("plate =", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotEqualTo(String value) {
            addCriterion("plate <>", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateGreaterThan(String value) {
            addCriterion("plate >", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateGreaterThanOrEqualTo(String value) {
            addCriterion("plate >=", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateLessThan(String value) {
            addCriterion("plate <", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateLessThanOrEqualTo(String value) {
            addCriterion("plate <=", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateLike(String value) {
            addCriterion("plate like", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotLike(String value) {
            addCriterion("plate not like", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateIn(List<String> values) {
            addCriterion("plate in", values, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotIn(List<String> values) {
            addCriterion("plate not in", values, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateBetween(String value1, String value2) {
            addCriterion("plate between", value1, value2, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotBetween(String value1, String value2) {
            addCriterion("plate not between", value1, value2, "plate");
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

        public Criteria andBuildYearIsNull() {
            addCriterion("build_year is null");
            return (Criteria) this;
        }

        public Criteria andBuildYearIsNotNull() {
            addCriterion("build_year is not null");
            return (Criteria) this;
        }

        public Criteria andBuildYearEqualTo(String value) {
            addCriterion("build_year =", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotEqualTo(String value) {
            addCriterion("build_year <>", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearGreaterThan(String value) {
            addCriterion("build_year >", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearGreaterThanOrEqualTo(String value) {
            addCriterion("build_year >=", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearLessThan(String value) {
            addCriterion("build_year <", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearLessThanOrEqualTo(String value) {
            addCriterion("build_year <=", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearLike(String value) {
            addCriterion("build_year like", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotLike(String value) {
            addCriterion("build_year not like", value, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearIn(List<String> values) {
            addCriterion("build_year in", values, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotIn(List<String> values) {
            addCriterion("build_year not in", values, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearBetween(String value1, String value2) {
            addCriterion("build_year between", value1, value2, "buildYear");
            return (Criteria) this;
        }

        public Criteria andBuildYearNotBetween(String value1, String value2) {
            addCriterion("build_year not between", value1, value2, "buildYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearIsNull() {
            addCriterion("property_year is null");
            return (Criteria) this;
        }

        public Criteria andPropertyYearIsNotNull() {
            addCriterion("property_year is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyYearEqualTo(String value) {
            addCriterion("property_year =", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearNotEqualTo(String value) {
            addCriterion("property_year <>", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearGreaterThan(String value) {
            addCriterion("property_year >", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearGreaterThanOrEqualTo(String value) {
            addCriterion("property_year >=", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearLessThan(String value) {
            addCriterion("property_year <", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearLessThanOrEqualTo(String value) {
            addCriterion("property_year <=", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearLike(String value) {
            addCriterion("property_year like", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearNotLike(String value) {
            addCriterion("property_year not like", value, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearIn(List<String> values) {
            addCriterion("property_year in", values, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearNotIn(List<String> values) {
            addCriterion("property_year not in", values, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearBetween(String value1, String value2) {
            addCriterion("property_year between", value1, value2, "propertyYear");
            return (Criteria) this;
        }

        public Criteria andPropertyYearNotBetween(String value1, String value2) {
            addCriterion("property_year not between", value1, value2, "propertyYear");
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

        public Criteria andLoudongNumIsNull() {
            addCriterion("loudong_num is null");
            return (Criteria) this;
        }

        public Criteria andLoudongNumIsNotNull() {
            addCriterion("loudong_num is not null");
            return (Criteria) this;
        }

        public Criteria andLoudongNumEqualTo(String value) {
            addCriterion("loudong_num =", value, "loudongNum");
            return (Criteria) this;
        }

        public Criteria andLoudongNumNotEqualTo(String value) {
            addCriterion("loudong_num <>", value, "loudongNum");
            return (Criteria) this;
        }

        public Criteria andLoudongNumGreaterThan(String value) {
            addCriterion("loudong_num >", value, "loudongNum");
            return (Criteria) this;
        }

        public Criteria andLoudongNumGreaterThanOrEqualTo(String value) {
            addCriterion("loudong_num >=", value, "loudongNum");
            return (Criteria) this;
        }

        public Criteria andLoudongNumLessThan(String value) {
            addCriterion("loudong_num <", value, "loudongNum");
            return (Criteria) this;
        }

        public Criteria andLoudongNumLessThanOrEqualTo(String value) {
            addCriterion("loudong_num <=", value, "loudongNum");
            return (Criteria) this;
        }

        public Criteria andLoudongNumLike(String value) {
            addCriterion("loudong_num like", value, "loudongNum");
            return (Criteria) this;
        }

        public Criteria andLoudongNumNotLike(String value) {
            addCriterion("loudong_num not like", value, "loudongNum");
            return (Criteria) this;
        }

        public Criteria andLoudongNumIn(List<String> values) {
            addCriterion("loudong_num in", values, "loudongNum");
            return (Criteria) this;
        }

        public Criteria andLoudongNumNotIn(List<String> values) {
            addCriterion("loudong_num not in", values, "loudongNum");
            return (Criteria) this;
        }

        public Criteria andLoudongNumBetween(String value1, String value2) {
            addCriterion("loudong_num between", value1, value2, "loudongNum");
            return (Criteria) this;
        }

        public Criteria andLoudongNumNotBetween(String value1, String value2) {
            addCriterion("loudong_num not between", value1, value2, "loudongNum");
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

        public Criteria andBuildTypeIsNull() {
            addCriterion("build_type is null");
            return (Criteria) this;
        }

        public Criteria andBuildTypeIsNotNull() {
            addCriterion("build_type is not null");
            return (Criteria) this;
        }

        public Criteria andBuildTypeEqualTo(String value) {
            addCriterion("build_type =", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotEqualTo(String value) {
            addCriterion("build_type <>", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeGreaterThan(String value) {
            addCriterion("build_type >", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeGreaterThanOrEqualTo(String value) {
            addCriterion("build_type >=", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeLessThan(String value) {
            addCriterion("build_type <", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeLessThanOrEqualTo(String value) {
            addCriterion("build_type <=", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeLike(String value) {
            addCriterion("build_type like", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotLike(String value) {
            addCriterion("build_type not like", value, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeIn(List<String> values) {
            addCriterion("build_type in", values, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotIn(List<String> values) {
            addCriterion("build_type not in", values, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeBetween(String value1, String value2) {
            addCriterion("build_type between", value1, value2, "buildType");
            return (Criteria) this;
        }

        public Criteria andBuildTypeNotBetween(String value1, String value2) {
            addCriterion("build_type not between", value1, value2, "buildType");
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

        public Criteria andFloorAreaIsNull() {
            addCriterion("floor_area is null");
            return (Criteria) this;
        }

        public Criteria andFloorAreaIsNotNull() {
            addCriterion("floor_area is not null");
            return (Criteria) this;
        }

        public Criteria andFloorAreaEqualTo(String value) {
            addCriterion("floor_area =", value, "floorArea");
            return (Criteria) this;
        }

        public Criteria andFloorAreaNotEqualTo(String value) {
            addCriterion("floor_area <>", value, "floorArea");
            return (Criteria) this;
        }

        public Criteria andFloorAreaGreaterThan(String value) {
            addCriterion("floor_area >", value, "floorArea");
            return (Criteria) this;
        }

        public Criteria andFloorAreaGreaterThanOrEqualTo(String value) {
            addCriterion("floor_area >=", value, "floorArea");
            return (Criteria) this;
        }

        public Criteria andFloorAreaLessThan(String value) {
            addCriterion("floor_area <", value, "floorArea");
            return (Criteria) this;
        }

        public Criteria andFloorAreaLessThanOrEqualTo(String value) {
            addCriterion("floor_area <=", value, "floorArea");
            return (Criteria) this;
        }

        public Criteria andFloorAreaLike(String value) {
            addCriterion("floor_area like", value, "floorArea");
            return (Criteria) this;
        }

        public Criteria andFloorAreaNotLike(String value) {
            addCriterion("floor_area not like", value, "floorArea");
            return (Criteria) this;
        }

        public Criteria andFloorAreaIn(List<String> values) {
            addCriterion("floor_area in", values, "floorArea");
            return (Criteria) this;
        }

        public Criteria andFloorAreaNotIn(List<String> values) {
            addCriterion("floor_area not in", values, "floorArea");
            return (Criteria) this;
        }

        public Criteria andFloorAreaBetween(String value1, String value2) {
            addCriterion("floor_area between", value1, value2, "floorArea");
            return (Criteria) this;
        }

        public Criteria andFloorAreaNotBetween(String value1, String value2) {
            addCriterion("floor_area not between", value1, value2, "floorArea");
            return (Criteria) this;
        }

        public Criteria andHeatingIsNull() {
            addCriterion("heating is null");
            return (Criteria) this;
        }

        public Criteria andHeatingIsNotNull() {
            addCriterion("heating is not null");
            return (Criteria) this;
        }

        public Criteria andHeatingEqualTo(String value) {
            addCriterion("heating =", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingNotEqualTo(String value) {
            addCriterion("heating <>", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingGreaterThan(String value) {
            addCriterion("heating >", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingGreaterThanOrEqualTo(String value) {
            addCriterion("heating >=", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingLessThan(String value) {
            addCriterion("heating <", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingLessThanOrEqualTo(String value) {
            addCriterion("heating <=", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingLike(String value) {
            addCriterion("heating like", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingNotLike(String value) {
            addCriterion("heating not like", value, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingIn(List<String> values) {
            addCriterion("heating in", values, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingNotIn(List<String> values) {
            addCriterion("heating not in", values, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingBetween(String value1, String value2) {
            addCriterion("heating between", value1, value2, "heating");
            return (Criteria) this;
        }

        public Criteria andHeatingNotBetween(String value1, String value2) {
            addCriterion("heating not between", value1, value2, "heating");
            return (Criteria) this;
        }

        public Criteria andGasIsNull() {
            addCriterion("gas is null");
            return (Criteria) this;
        }

        public Criteria andGasIsNotNull() {
            addCriterion("gas is not null");
            return (Criteria) this;
        }

        public Criteria andGasEqualTo(String value) {
            addCriterion("gas =", value, "gas");
            return (Criteria) this;
        }

        public Criteria andGasNotEqualTo(String value) {
            addCriterion("gas <>", value, "gas");
            return (Criteria) this;
        }

        public Criteria andGasGreaterThan(String value) {
            addCriterion("gas >", value, "gas");
            return (Criteria) this;
        }

        public Criteria andGasGreaterThanOrEqualTo(String value) {
            addCriterion("gas >=", value, "gas");
            return (Criteria) this;
        }

        public Criteria andGasLessThan(String value) {
            addCriterion("gas <", value, "gas");
            return (Criteria) this;
        }

        public Criteria andGasLessThanOrEqualTo(String value) {
            addCriterion("gas <=", value, "gas");
            return (Criteria) this;
        }

        public Criteria andGasLike(String value) {
            addCriterion("gas like", value, "gas");
            return (Criteria) this;
        }

        public Criteria andGasNotLike(String value) {
            addCriterion("gas not like", value, "gas");
            return (Criteria) this;
        }

        public Criteria andGasIn(List<String> values) {
            addCriterion("gas in", values, "gas");
            return (Criteria) this;
        }

        public Criteria andGasNotIn(List<String> values) {
            addCriterion("gas not in", values, "gas");
            return (Criteria) this;
        }

        public Criteria andGasBetween(String value1, String value2) {
            addCriterion("gas between", value1, value2, "gas");
            return (Criteria) this;
        }

        public Criteria andGasNotBetween(String value1, String value2) {
            addCriterion("gas not between", value1, value2, "gas");
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

        public Criteria andElevatorIsNull() {
            addCriterion("elevator is null");
            return (Criteria) this;
        }

        public Criteria andElevatorIsNotNull() {
            addCriterion("elevator is not null");
            return (Criteria) this;
        }

        public Criteria andElevatorEqualTo(String value) {
            addCriterion("elevator =", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorNotEqualTo(String value) {
            addCriterion("elevator <>", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorGreaterThan(String value) {
            addCriterion("elevator >", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorGreaterThanOrEqualTo(String value) {
            addCriterion("elevator >=", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorLessThan(String value) {
            addCriterion("elevator <", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorLessThanOrEqualTo(String value) {
            addCriterion("elevator <=", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorLike(String value) {
            addCriterion("elevator like", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorNotLike(String value) {
            addCriterion("elevator not like", value, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorIn(List<String> values) {
            addCriterion("elevator in", values, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorNotIn(List<String> values) {
            addCriterion("elevator not in", values, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorBetween(String value1, String value2) {
            addCriterion("elevator between", value1, value2, "elevator");
            return (Criteria) this;
        }

        public Criteria andElevatorNotBetween(String value1, String value2) {
            addCriterion("elevator not between", value1, value2, "elevator");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendIsNull() {
            addCriterion("average_price_trend is null");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendIsNotNull() {
            addCriterion("average_price_trend is not null");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendEqualTo(String value) {
            addCriterion("average_price_trend =", value, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendNotEqualTo(String value) {
            addCriterion("average_price_trend <>", value, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendGreaterThan(String value) {
            addCriterion("average_price_trend >", value, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendGreaterThanOrEqualTo(String value) {
            addCriterion("average_price_trend >=", value, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendLessThan(String value) {
            addCriterion("average_price_trend <", value, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendLessThanOrEqualTo(String value) {
            addCriterion("average_price_trend <=", value, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendLike(String value) {
            addCriterion("average_price_trend like", value, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendNotLike(String value) {
            addCriterion("average_price_trend not like", value, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendIn(List<String> values) {
            addCriterion("average_price_trend in", values, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendNotIn(List<String> values) {
            addCriterion("average_price_trend not in", values, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendBetween(String value1, String value2) {
            addCriterion("average_price_trend between", value1, value2, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andAveragePriceTrendNotBetween(String value1, String value2) {
            addCriterion("average_price_trend not between", value1, value2, "averagePriceTrend");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumIsNull() {
            addCriterion("jiaoyi_num is null");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumIsNotNull() {
            addCriterion("jiaoyi_num is not null");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumEqualTo(String value) {
            addCriterion("jiaoyi_num =", value, "jiaoyiNum");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumNotEqualTo(String value) {
            addCriterion("jiaoyi_num <>", value, "jiaoyiNum");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumGreaterThan(String value) {
            addCriterion("jiaoyi_num >", value, "jiaoyiNum");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumGreaterThanOrEqualTo(String value) {
            addCriterion("jiaoyi_num >=", value, "jiaoyiNum");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumLessThan(String value) {
            addCriterion("jiaoyi_num <", value, "jiaoyiNum");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumLessThanOrEqualTo(String value) {
            addCriterion("jiaoyi_num <=", value, "jiaoyiNum");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumLike(String value) {
            addCriterion("jiaoyi_num like", value, "jiaoyiNum");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumNotLike(String value) {
            addCriterion("jiaoyi_num not like", value, "jiaoyiNum");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumIn(List<String> values) {
            addCriterion("jiaoyi_num in", values, "jiaoyiNum");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumNotIn(List<String> values) {
            addCriterion("jiaoyi_num not in", values, "jiaoyiNum");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumBetween(String value1, String value2) {
            addCriterion("jiaoyi_num between", value1, value2, "jiaoyiNum");
            return (Criteria) this;
        }

        public Criteria andJiaoyiNumNotBetween(String value1, String value2) {
            addCriterion("jiaoyi_num not between", value1, value2, "jiaoyiNum");
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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