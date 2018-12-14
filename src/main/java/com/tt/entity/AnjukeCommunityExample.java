package com.tt.entity;

import java.util.ArrayList;
import java.util.List;

public class AnjukeCommunityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnjukeCommunityExample() {
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

        public Criteria andAveragePriceIsNull() {
            addCriterion("average_price is null");
            return (Criteria) this;
        }

        public Criteria andAveragePriceIsNotNull() {
            addCriterion("average_price is not null");
            return (Criteria) this;
        }

        public Criteria andAveragePriceEqualTo(String value) {
            addCriterion("average_price =", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotEqualTo(String value) {
            addCriterion("average_price <>", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceGreaterThan(String value) {
            addCriterion("average_price >", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceGreaterThanOrEqualTo(String value) {
            addCriterion("average_price >=", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceLessThan(String value) {
            addCriterion("average_price <", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceLessThanOrEqualTo(String value) {
            addCriterion("average_price <=", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceLike(String value) {
            addCriterion("average_price like", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotLike(String value) {
            addCriterion("average_price not like", value, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceIn(List<String> values) {
            addCriterion("average_price in", values, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotIn(List<String> values) {
            addCriterion("average_price not in", values, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceBetween(String value1, String value2) {
            addCriterion("average_price between", value1, value2, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andAveragePriceNotBetween(String value1, String value2) {
            addCriterion("average_price not between", value1, value2, "averagePrice");
            return (Criteria) this;
        }

        public Criteria andThumbUrlIsNull() {
            addCriterion("thumb_url is null");
            return (Criteria) this;
        }

        public Criteria andThumbUrlIsNotNull() {
            addCriterion("thumb_url is not null");
            return (Criteria) this;
        }

        public Criteria andThumbUrlEqualTo(String value) {
            addCriterion("thumb_url =", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotEqualTo(String value) {
            addCriterion("thumb_url <>", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlGreaterThan(String value) {
            addCriterion("thumb_url >", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlGreaterThanOrEqualTo(String value) {
            addCriterion("thumb_url >=", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlLessThan(String value) {
            addCriterion("thumb_url <", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlLessThanOrEqualTo(String value) {
            addCriterion("thumb_url <=", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlLike(String value) {
            addCriterion("thumb_url like", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotLike(String value) {
            addCriterion("thumb_url not like", value, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlIn(List<String> values) {
            addCriterion("thumb_url in", values, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotIn(List<String> values) {
            addCriterion("thumb_url not in", values, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlBetween(String value1, String value2) {
            addCriterion("thumb_url between", value1, value2, "thumbUrl");
            return (Criteria) this;
        }

        public Criteria andThumbUrlNotBetween(String value1, String value2) {
            addCriterion("thumb_url not between", value1, value2, "thumbUrl");
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

        public Criteria andBuildStructureIsNull() {
            addCriterion("build_structure is null");
            return (Criteria) this;
        }

        public Criteria andBuildStructureIsNotNull() {
            addCriterion("build_structure is not null");
            return (Criteria) this;
        }

        public Criteria andBuildStructureEqualTo(String value) {
            addCriterion("build_structure =", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureNotEqualTo(String value) {
            addCriterion("build_structure <>", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureGreaterThan(String value) {
            addCriterion("build_structure >", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureGreaterThanOrEqualTo(String value) {
            addCriterion("build_structure >=", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureLessThan(String value) {
            addCriterion("build_structure <", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureLessThanOrEqualTo(String value) {
            addCriterion("build_structure <=", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureLike(String value) {
            addCriterion("build_structure like", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureNotLike(String value) {
            addCriterion("build_structure not like", value, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureIn(List<String> values) {
            addCriterion("build_structure in", values, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureNotIn(List<String> values) {
            addCriterion("build_structure not in", values, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureBetween(String value1, String value2) {
            addCriterion("build_structure between", value1, value2, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andBuildStructureNotBetween(String value1, String value2) {
            addCriterion("build_structure not between", value1, value2, "buildStructure");
            return (Criteria) this;
        }

        public Criteria andLoopPositionIsNull() {
            addCriterion("loop_position is null");
            return (Criteria) this;
        }

        public Criteria andLoopPositionIsNotNull() {
            addCriterion("loop_position is not null");
            return (Criteria) this;
        }

        public Criteria andLoopPositionEqualTo(String value) {
            addCriterion("loop_position =", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionNotEqualTo(String value) {
            addCriterion("loop_position <>", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionGreaterThan(String value) {
            addCriterion("loop_position >", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionGreaterThanOrEqualTo(String value) {
            addCriterion("loop_position >=", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionLessThan(String value) {
            addCriterion("loop_position <", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionLessThanOrEqualTo(String value) {
            addCriterion("loop_position <=", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionLike(String value) {
            addCriterion("loop_position like", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionNotLike(String value) {
            addCriterion("loop_position not like", value, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionIn(List<String> values) {
            addCriterion("loop_position in", values, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionNotIn(List<String> values) {
            addCriterion("loop_position not in", values, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionBetween(String value1, String value2) {
            addCriterion("loop_position between", value1, value2, "loopPosition");
            return (Criteria) this;
        }

        public Criteria andLoopPositionNotBetween(String value1, String value2) {
            addCriterion("loop_position not between", value1, value2, "loopPosition");
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

        public Criteria andChanquanDescriptionIsNull() {
            addCriterion("chanquan_description is null");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionIsNotNull() {
            addCriterion("chanquan_description is not null");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionEqualTo(String value) {
            addCriterion("chanquan_description =", value, "chanquanDescription");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionNotEqualTo(String value) {
            addCriterion("chanquan_description <>", value, "chanquanDescription");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionGreaterThan(String value) {
            addCriterion("chanquan_description >", value, "chanquanDescription");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("chanquan_description >=", value, "chanquanDescription");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionLessThan(String value) {
            addCriterion("chanquan_description <", value, "chanquanDescription");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionLessThanOrEqualTo(String value) {
            addCriterion("chanquan_description <=", value, "chanquanDescription");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionLike(String value) {
            addCriterion("chanquan_description like", value, "chanquanDescription");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionNotLike(String value) {
            addCriterion("chanquan_description not like", value, "chanquanDescription");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionIn(List<String> values) {
            addCriterion("chanquan_description in", values, "chanquanDescription");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionNotIn(List<String> values) {
            addCriterion("chanquan_description not in", values, "chanquanDescription");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionBetween(String value1, String value2) {
            addCriterion("chanquan_description between", value1, value2, "chanquanDescription");
            return (Criteria) this;
        }

        public Criteria andChanquanDescriptionNotBetween(String value1, String value2) {
            addCriterion("chanquan_description not between", value1, value2, "chanquanDescription");
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

        public Criteria andPropertyPhoneIsNull() {
            addCriterion("property_phone is null");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneIsNotNull() {
            addCriterion("property_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneEqualTo(String value) {
            addCriterion("property_phone =", value, "propertyPhone");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneNotEqualTo(String value) {
            addCriterion("property_phone <>", value, "propertyPhone");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneGreaterThan(String value) {
            addCriterion("property_phone >", value, "propertyPhone");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("property_phone >=", value, "propertyPhone");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneLessThan(String value) {
            addCriterion("property_phone <", value, "propertyPhone");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneLessThanOrEqualTo(String value) {
            addCriterion("property_phone <=", value, "propertyPhone");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneLike(String value) {
            addCriterion("property_phone like", value, "propertyPhone");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneNotLike(String value) {
            addCriterion("property_phone not like", value, "propertyPhone");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneIn(List<String> values) {
            addCriterion("property_phone in", values, "propertyPhone");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneNotIn(List<String> values) {
            addCriterion("property_phone not in", values, "propertyPhone");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneBetween(String value1, String value2) {
            addCriterion("property_phone between", value1, value2, "propertyPhone");
            return (Criteria) this;
        }

        public Criteria andPropertyPhoneNotBetween(String value1, String value2) {
            addCriterion("property_phone not between", value1, value2, "propertyPhone");
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

        public Criteria andServiceCenterIsNull() {
            addCriterion("service_center is null");
            return (Criteria) this;
        }

        public Criteria andServiceCenterIsNotNull() {
            addCriterion("service_center is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCenterEqualTo(String value) {
            addCriterion("service_center =", value, "serviceCenter");
            return (Criteria) this;
        }

        public Criteria andServiceCenterNotEqualTo(String value) {
            addCriterion("service_center <>", value, "serviceCenter");
            return (Criteria) this;
        }

        public Criteria andServiceCenterGreaterThan(String value) {
            addCriterion("service_center >", value, "serviceCenter");
            return (Criteria) this;
        }

        public Criteria andServiceCenterGreaterThanOrEqualTo(String value) {
            addCriterion("service_center >=", value, "serviceCenter");
            return (Criteria) this;
        }

        public Criteria andServiceCenterLessThan(String value) {
            addCriterion("service_center <", value, "serviceCenter");
            return (Criteria) this;
        }

        public Criteria andServiceCenterLessThanOrEqualTo(String value) {
            addCriterion("service_center <=", value, "serviceCenter");
            return (Criteria) this;
        }

        public Criteria andServiceCenterLike(String value) {
            addCriterion("service_center like", value, "serviceCenter");
            return (Criteria) this;
        }

        public Criteria andServiceCenterNotLike(String value) {
            addCriterion("service_center not like", value, "serviceCenter");
            return (Criteria) this;
        }

        public Criteria andServiceCenterIn(List<String> values) {
            addCriterion("service_center in", values, "serviceCenter");
            return (Criteria) this;
        }

        public Criteria andServiceCenterNotIn(List<String> values) {
            addCriterion("service_center not in", values, "serviceCenter");
            return (Criteria) this;
        }

        public Criteria andServiceCenterBetween(String value1, String value2) {
            addCriterion("service_center between", value1, value2, "serviceCenter");
            return (Criteria) this;
        }

        public Criteria andServiceCenterNotBetween(String value1, String value2) {
            addCriterion("service_center not between", value1, value2, "serviceCenter");
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

        public Criteria andWaterIsNull() {
            addCriterion("water is null");
            return (Criteria) this;
        }

        public Criteria andWaterIsNotNull() {
            addCriterion("water is not null");
            return (Criteria) this;
        }

        public Criteria andWaterEqualTo(String value) {
            addCriterion("water =", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotEqualTo(String value) {
            addCriterion("water <>", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThan(String value) {
            addCriterion("water >", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThanOrEqualTo(String value) {
            addCriterion("water >=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThan(String value) {
            addCriterion("water <", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThanOrEqualTo(String value) {
            addCriterion("water <=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLike(String value) {
            addCriterion("water like", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotLike(String value) {
            addCriterion("water not like", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterIn(List<String> values) {
            addCriterion("water in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotIn(List<String> values) {
            addCriterion("water not in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterBetween(String value1, String value2) {
            addCriterion("water between", value1, value2, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotBetween(String value1, String value2) {
            addCriterion("water not between", value1, value2, "water");
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

        public Criteria andSupplyElectricityIsNull() {
            addCriterion("supply_electricity is null");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityIsNotNull() {
            addCriterion("supply_electricity is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityEqualTo(String value) {
            addCriterion("supply_electricity =", value, "supplyElectricity");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityNotEqualTo(String value) {
            addCriterion("supply_electricity <>", value, "supplyElectricity");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityGreaterThan(String value) {
            addCriterion("supply_electricity >", value, "supplyElectricity");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityGreaterThanOrEqualTo(String value) {
            addCriterion("supply_electricity >=", value, "supplyElectricity");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityLessThan(String value) {
            addCriterion("supply_electricity <", value, "supplyElectricity");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityLessThanOrEqualTo(String value) {
            addCriterion("supply_electricity <=", value, "supplyElectricity");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityLike(String value) {
            addCriterion("supply_electricity like", value, "supplyElectricity");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityNotLike(String value) {
            addCriterion("supply_electricity not like", value, "supplyElectricity");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityIn(List<String> values) {
            addCriterion("supply_electricity in", values, "supplyElectricity");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityNotIn(List<String> values) {
            addCriterion("supply_electricity not in", values, "supplyElectricity");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityBetween(String value1, String value2) {
            addCriterion("supply_electricity between", value1, value2, "supplyElectricity");
            return (Criteria) this;
        }

        public Criteria andSupplyElectricityNotBetween(String value1, String value2) {
            addCriterion("supply_electricity not between", value1, value2, "supplyElectricity");
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

        public Criteria andDiantiIsNull() {
            addCriterion("dianti is null");
            return (Criteria) this;
        }

        public Criteria andDiantiIsNotNull() {
            addCriterion("dianti is not null");
            return (Criteria) this;
        }

        public Criteria andDiantiEqualTo(String value) {
            addCriterion("dianti =", value, "dianti");
            return (Criteria) this;
        }

        public Criteria andDiantiNotEqualTo(String value) {
            addCriterion("dianti <>", value, "dianti");
            return (Criteria) this;
        }

        public Criteria andDiantiGreaterThan(String value) {
            addCriterion("dianti >", value, "dianti");
            return (Criteria) this;
        }

        public Criteria andDiantiGreaterThanOrEqualTo(String value) {
            addCriterion("dianti >=", value, "dianti");
            return (Criteria) this;
        }

        public Criteria andDiantiLessThan(String value) {
            addCriterion("dianti <", value, "dianti");
            return (Criteria) this;
        }

        public Criteria andDiantiLessThanOrEqualTo(String value) {
            addCriterion("dianti <=", value, "dianti");
            return (Criteria) this;
        }

        public Criteria andDiantiLike(String value) {
            addCriterion("dianti like", value, "dianti");
            return (Criteria) this;
        }

        public Criteria andDiantiNotLike(String value) {
            addCriterion("dianti not like", value, "dianti");
            return (Criteria) this;
        }

        public Criteria andDiantiIn(List<String> values) {
            addCriterion("dianti in", values, "dianti");
            return (Criteria) this;
        }

        public Criteria andDiantiNotIn(List<String> values) {
            addCriterion("dianti not in", values, "dianti");
            return (Criteria) this;
        }

        public Criteria andDiantiBetween(String value1, String value2) {
            addCriterion("dianti between", value1, value2, "dianti");
            return (Criteria) this;
        }

        public Criteria andDiantiNotBetween(String value1, String value2) {
            addCriterion("dianti not between", value1, value2, "dianti");
            return (Criteria) this;
        }

        public Criteria andSecurityIsNull() {
            addCriterion("security is null");
            return (Criteria) this;
        }

        public Criteria andSecurityIsNotNull() {
            addCriterion("security is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityEqualTo(String value) {
            addCriterion("security =", value, "security");
            return (Criteria) this;
        }

        public Criteria andSecurityNotEqualTo(String value) {
            addCriterion("security <>", value, "security");
            return (Criteria) this;
        }

        public Criteria andSecurityGreaterThan(String value) {
            addCriterion("security >", value, "security");
            return (Criteria) this;
        }

        public Criteria andSecurityGreaterThanOrEqualTo(String value) {
            addCriterion("security >=", value, "security");
            return (Criteria) this;
        }

        public Criteria andSecurityLessThan(String value) {
            addCriterion("security <", value, "security");
            return (Criteria) this;
        }

        public Criteria andSecurityLessThanOrEqualTo(String value) {
            addCriterion("security <=", value, "security");
            return (Criteria) this;
        }

        public Criteria andSecurityLike(String value) {
            addCriterion("security like", value, "security");
            return (Criteria) this;
        }

        public Criteria andSecurityNotLike(String value) {
            addCriterion("security not like", value, "security");
            return (Criteria) this;
        }

        public Criteria andSecurityIn(List<String> values) {
            addCriterion("security in", values, "security");
            return (Criteria) this;
        }

        public Criteria andSecurityNotIn(List<String> values) {
            addCriterion("security not in", values, "security");
            return (Criteria) this;
        }

        public Criteria andSecurityBetween(String value1, String value2) {
            addCriterion("security between", value1, value2, "security");
            return (Criteria) this;
        }

        public Criteria andSecurityNotBetween(String value1, String value2) {
            addCriterion("security not between", value1, value2, "security");
            return (Criteria) this;
        }

        public Criteria andWeishengIsNull() {
            addCriterion("weisheng is null");
            return (Criteria) this;
        }

        public Criteria andWeishengIsNotNull() {
            addCriterion("weisheng is not null");
            return (Criteria) this;
        }

        public Criteria andWeishengEqualTo(String value) {
            addCriterion("weisheng =", value, "weisheng");
            return (Criteria) this;
        }

        public Criteria andWeishengNotEqualTo(String value) {
            addCriterion("weisheng <>", value, "weisheng");
            return (Criteria) this;
        }

        public Criteria andWeishengGreaterThan(String value) {
            addCriterion("weisheng >", value, "weisheng");
            return (Criteria) this;
        }

        public Criteria andWeishengGreaterThanOrEqualTo(String value) {
            addCriterion("weisheng >=", value, "weisheng");
            return (Criteria) this;
        }

        public Criteria andWeishengLessThan(String value) {
            addCriterion("weisheng <", value, "weisheng");
            return (Criteria) this;
        }

        public Criteria andWeishengLessThanOrEqualTo(String value) {
            addCriterion("weisheng <=", value, "weisheng");
            return (Criteria) this;
        }

        public Criteria andWeishengLike(String value) {
            addCriterion("weisheng like", value, "weisheng");
            return (Criteria) this;
        }

        public Criteria andWeishengNotLike(String value) {
            addCriterion("weisheng not like", value, "weisheng");
            return (Criteria) this;
        }

        public Criteria andWeishengIn(List<String> values) {
            addCriterion("weisheng in", values, "weisheng");
            return (Criteria) this;
        }

        public Criteria andWeishengNotIn(List<String> values) {
            addCriterion("weisheng not in", values, "weisheng");
            return (Criteria) this;
        }

        public Criteria andWeishengBetween(String value1, String value2) {
            addCriterion("weisheng between", value1, value2, "weisheng");
            return (Criteria) this;
        }

        public Criteria andWeishengNotBetween(String value1, String value2) {
            addCriterion("weisheng not between", value1, value2, "weisheng");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceIsNull() {
            addCriterion("parking_space is null");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceIsNotNull() {
            addCriterion("parking_space is not null");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceEqualTo(String value) {
            addCriterion("parking_space =", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNotEqualTo(String value) {
            addCriterion("parking_space <>", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceGreaterThan(String value) {
            addCriterion("parking_space >", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceGreaterThanOrEqualTo(String value) {
            addCriterion("parking_space >=", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceLessThan(String value) {
            addCriterion("parking_space <", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceLessThanOrEqualTo(String value) {
            addCriterion("parking_space <=", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceLike(String value) {
            addCriterion("parking_space like", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNotLike(String value) {
            addCriterion("parking_space not like", value, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceIn(List<String> values) {
            addCriterion("parking_space in", values, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNotIn(List<String> values) {
            addCriterion("parking_space not in", values, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceBetween(String value1, String value2) {
            addCriterion("parking_space between", value1, value2, "parkingSpace");
            return (Criteria) this;
        }

        public Criteria andParkingSpaceNotBetween(String value1, String value2) {
            addCriterion("parking_space not between", value1, value2, "parkingSpace");
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

        public Criteria andXiaoquEsfUrlIsNull() {
            addCriterion("xiaoqu_esf_url is null");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlIsNotNull() {
            addCriterion("xiaoqu_esf_url is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlEqualTo(String value) {
            addCriterion("xiaoqu_esf_url =", value, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlNotEqualTo(String value) {
            addCriterion("xiaoqu_esf_url <>", value, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlGreaterThan(String value) {
            addCriterion("xiaoqu_esf_url >", value, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlGreaterThanOrEqualTo(String value) {
            addCriterion("xiaoqu_esf_url >=", value, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlLessThan(String value) {
            addCriterion("xiaoqu_esf_url <", value, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlLessThanOrEqualTo(String value) {
            addCriterion("xiaoqu_esf_url <=", value, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlLike(String value) {
            addCriterion("xiaoqu_esf_url like", value, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlNotLike(String value) {
            addCriterion("xiaoqu_esf_url not like", value, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlIn(List<String> values) {
            addCriterion("xiaoqu_esf_url in", values, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlNotIn(List<String> values) {
            addCriterion("xiaoqu_esf_url not in", values, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlBetween(String value1, String value2) {
            addCriterion("xiaoqu_esf_url between", value1, value2, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquEsfUrlNotBetween(String value1, String value2) {
            addCriterion("xiaoqu_esf_url not between", value1, value2, "xiaoquEsfUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlIsNull() {
            addCriterion("xiaoqu_zufang_url is null");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlIsNotNull() {
            addCriterion("xiaoqu_zufang_url is not null");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlEqualTo(String value) {
            addCriterion("xiaoqu_zufang_url =", value, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlNotEqualTo(String value) {
            addCriterion("xiaoqu_zufang_url <>", value, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlGreaterThan(String value) {
            addCriterion("xiaoqu_zufang_url >", value, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlGreaterThanOrEqualTo(String value) {
            addCriterion("xiaoqu_zufang_url >=", value, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlLessThan(String value) {
            addCriterion("xiaoqu_zufang_url <", value, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlLessThanOrEqualTo(String value) {
            addCriterion("xiaoqu_zufang_url <=", value, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlLike(String value) {
            addCriterion("xiaoqu_zufang_url like", value, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlNotLike(String value) {
            addCriterion("xiaoqu_zufang_url not like", value, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlIn(List<String> values) {
            addCriterion("xiaoqu_zufang_url in", values, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlNotIn(List<String> values) {
            addCriterion("xiaoqu_zufang_url not in", values, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlBetween(String value1, String value2) {
            addCriterion("xiaoqu_zufang_url between", value1, value2, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andXiaoquZufangUrlNotBetween(String value1, String value2) {
            addCriterion("xiaoqu_zufang_url not between", value1, value2, "xiaoquZufangUrl");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelIsNull() {
            addCriterion("offices_level is null");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelIsNotNull() {
            addCriterion("offices_level is not null");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelEqualTo(String value) {
            addCriterion("offices_level =", value, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelNotEqualTo(String value) {
            addCriterion("offices_level <>", value, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelGreaterThan(String value) {
            addCriterion("offices_level >", value, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelGreaterThanOrEqualTo(String value) {
            addCriterion("offices_level >=", value, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelLessThan(String value) {
            addCriterion("offices_level <", value, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelLessThanOrEqualTo(String value) {
            addCriterion("offices_level <=", value, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelLike(String value) {
            addCriterion("offices_level like", value, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelNotLike(String value) {
            addCriterion("offices_level not like", value, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelIn(List<String> values) {
            addCriterion("offices_level in", values, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelNotIn(List<String> values) {
            addCriterion("offices_level not in", values, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelBetween(String value1, String value2) {
            addCriterion("offices_level between", value1, value2, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andOfficesLevelNotBetween(String value1, String value2) {
            addCriterion("offices_level not between", value1, value2, "officesLevel");
            return (Criteria) this;
        }

        public Criteria andZufangInfoIsNull() {
            addCriterion("zufang_info is null");
            return (Criteria) this;
        }

        public Criteria andZufangInfoIsNotNull() {
            addCriterion("zufang_info is not null");
            return (Criteria) this;
        }

        public Criteria andZufangInfoEqualTo(String value) {
            addCriterion("zufang_info =", value, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andZufangInfoNotEqualTo(String value) {
            addCriterion("zufang_info <>", value, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andZufangInfoGreaterThan(String value) {
            addCriterion("zufang_info >", value, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andZufangInfoGreaterThanOrEqualTo(String value) {
            addCriterion("zufang_info >=", value, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andZufangInfoLessThan(String value) {
            addCriterion("zufang_info <", value, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andZufangInfoLessThanOrEqualTo(String value) {
            addCriterion("zufang_info <=", value, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andZufangInfoLike(String value) {
            addCriterion("zufang_info like", value, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andZufangInfoNotLike(String value) {
            addCriterion("zufang_info not like", value, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andZufangInfoIn(List<String> values) {
            addCriterion("zufang_info in", values, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andZufangInfoNotIn(List<String> values) {
            addCriterion("zufang_info not in", values, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andZufangInfoBetween(String value1, String value2) {
            addCriterion("zufang_info between", value1, value2, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andZufangInfoNotBetween(String value1, String value2) {
            addCriterion("zufang_info not between", value1, value2, "zufangInfo");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andDiantiNumIsNull() {
            addCriterion("dianti_num is null");
            return (Criteria) this;
        }

        public Criteria andDiantiNumIsNotNull() {
            addCriterion("dianti_num is not null");
            return (Criteria) this;
        }

        public Criteria andDiantiNumEqualTo(String value) {
            addCriterion("dianti_num =", value, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDiantiNumNotEqualTo(String value) {
            addCriterion("dianti_num <>", value, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDiantiNumGreaterThan(String value) {
            addCriterion("dianti_num >", value, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDiantiNumGreaterThanOrEqualTo(String value) {
            addCriterion("dianti_num >=", value, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDiantiNumLessThan(String value) {
            addCriterion("dianti_num <", value, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDiantiNumLessThanOrEqualTo(String value) {
            addCriterion("dianti_num <=", value, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDiantiNumLike(String value) {
            addCriterion("dianti_num like", value, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDiantiNumNotLike(String value) {
            addCriterion("dianti_num not like", value, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDiantiNumIn(List<String> values) {
            addCriterion("dianti_num in", values, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDiantiNumNotIn(List<String> values) {
            addCriterion("dianti_num not in", values, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDiantiNumBetween(String value1, String value2) {
            addCriterion("dianti_num between", value1, value2, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDiantiNumNotBetween(String value1, String value2) {
            addCriterion("dianti_num not between", value1, value2, "diantiNum");
            return (Criteria) this;
        }

        public Criteria andDecorationIsNull() {
            addCriterion("decoration is null");
            return (Criteria) this;
        }

        public Criteria andDecorationIsNotNull() {
            addCriterion("decoration is not null");
            return (Criteria) this;
        }

        public Criteria andDecorationEqualTo(String value) {
            addCriterion("decoration =", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotEqualTo(String value) {
            addCriterion("decoration <>", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationGreaterThan(String value) {
            addCriterion("decoration >", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationGreaterThanOrEqualTo(String value) {
            addCriterion("decoration >=", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLessThan(String value) {
            addCriterion("decoration <", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLessThanOrEqualTo(String value) {
            addCriterion("decoration <=", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationLike(String value) {
            addCriterion("decoration like", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotLike(String value) {
            addCriterion("decoration not like", value, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationIn(List<String> values) {
            addCriterion("decoration in", values, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotIn(List<String> values) {
            addCriterion("decoration not in", values, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationBetween(String value1, String value2) {
            addCriterion("decoration between", value1, value2, "decoration");
            return (Criteria) this;
        }

        public Criteria andDecorationNotBetween(String value1, String value2) {
            addCriterion("decoration not between", value1, value2, "decoration");
            return (Criteria) this;
        }

        public Criteria andFloorNumIsNull() {
            addCriterion("floor_num is null");
            return (Criteria) this;
        }

        public Criteria andFloorNumIsNotNull() {
            addCriterion("floor_num is not null");
            return (Criteria) this;
        }

        public Criteria andFloorNumEqualTo(String value) {
            addCriterion("floor_num =", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumNotEqualTo(String value) {
            addCriterion("floor_num <>", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumGreaterThan(String value) {
            addCriterion("floor_num >", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumGreaterThanOrEqualTo(String value) {
            addCriterion("floor_num >=", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumLessThan(String value) {
            addCriterion("floor_num <", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumLessThanOrEqualTo(String value) {
            addCriterion("floor_num <=", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumLike(String value) {
            addCriterion("floor_num like", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumNotLike(String value) {
            addCriterion("floor_num not like", value, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumIn(List<String> values) {
            addCriterion("floor_num in", values, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumNotIn(List<String> values) {
            addCriterion("floor_num not in", values, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumBetween(String value1, String value2) {
            addCriterion("floor_num between", value1, value2, "floorNum");
            return (Criteria) this;
        }

        public Criteria andFloorNumNotBetween(String value1, String value2) {
            addCriterion("floor_num not between", value1, value2, "floorNum");
            return (Criteria) this;
        }

        public Criteria andParkRatioIsNull() {
            addCriterion("park_ratio is null");
            return (Criteria) this;
        }

        public Criteria andParkRatioIsNotNull() {
            addCriterion("park_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andParkRatioEqualTo(String value) {
            addCriterion("park_ratio =", value, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andParkRatioNotEqualTo(String value) {
            addCriterion("park_ratio <>", value, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andParkRatioGreaterThan(String value) {
            addCriterion("park_ratio >", value, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andParkRatioGreaterThanOrEqualTo(String value) {
            addCriterion("park_ratio >=", value, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andParkRatioLessThan(String value) {
            addCriterion("park_ratio <", value, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andParkRatioLessThanOrEqualTo(String value) {
            addCriterion("park_ratio <=", value, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andParkRatioLike(String value) {
            addCriterion("park_ratio like", value, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andParkRatioNotLike(String value) {
            addCriterion("park_ratio not like", value, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andParkRatioIn(List<String> values) {
            addCriterion("park_ratio in", values, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andParkRatioNotIn(List<String> values) {
            addCriterion("park_ratio not in", values, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andParkRatioBetween(String value1, String value2) {
            addCriterion("park_ratio between", value1, value2, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andParkRatioNotBetween(String value1, String value2) {
            addCriterion("park_ratio not between", value1, value2, "parkRatio");
            return (Criteria) this;
        }

        public Criteria andUnderNumIsNull() {
            addCriterion("under_num is null");
            return (Criteria) this;
        }

        public Criteria andUnderNumIsNotNull() {
            addCriterion("under_num is not null");
            return (Criteria) this;
        }

        public Criteria andUnderNumEqualTo(String value) {
            addCriterion("under_num =", value, "underNum");
            return (Criteria) this;
        }

        public Criteria andUnderNumNotEqualTo(String value) {
            addCriterion("under_num <>", value, "underNum");
            return (Criteria) this;
        }

        public Criteria andUnderNumGreaterThan(String value) {
            addCriterion("under_num >", value, "underNum");
            return (Criteria) this;
        }

        public Criteria andUnderNumGreaterThanOrEqualTo(String value) {
            addCriterion("under_num >=", value, "underNum");
            return (Criteria) this;
        }

        public Criteria andUnderNumLessThan(String value) {
            addCriterion("under_num <", value, "underNum");
            return (Criteria) this;
        }

        public Criteria andUnderNumLessThanOrEqualTo(String value) {
            addCriterion("under_num <=", value, "underNum");
            return (Criteria) this;
        }

        public Criteria andUnderNumLike(String value) {
            addCriterion("under_num like", value, "underNum");
            return (Criteria) this;
        }

        public Criteria andUnderNumNotLike(String value) {
            addCriterion("under_num not like", value, "underNum");
            return (Criteria) this;
        }

        public Criteria andUnderNumIn(List<String> values) {
            addCriterion("under_num in", values, "underNum");
            return (Criteria) this;
        }

        public Criteria andUnderNumNotIn(List<String> values) {
            addCriterion("under_num not in", values, "underNum");
            return (Criteria) this;
        }

        public Criteria andUnderNumBetween(String value1, String value2) {
            addCriterion("under_num between", value1, value2, "underNum");
            return (Criteria) this;
        }

        public Criteria andUnderNumNotBetween(String value1, String value2) {
            addCriterion("under_num not between", value1, value2, "underNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumIsNull() {
            addCriterion("upper_num is null");
            return (Criteria) this;
        }

        public Criteria andUpperNumIsNotNull() {
            addCriterion("upper_num is not null");
            return (Criteria) this;
        }

        public Criteria andUpperNumEqualTo(String value) {
            addCriterion("upper_num =", value, "upperNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumNotEqualTo(String value) {
            addCriterion("upper_num <>", value, "upperNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumGreaterThan(String value) {
            addCriterion("upper_num >", value, "upperNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumGreaterThanOrEqualTo(String value) {
            addCriterion("upper_num >=", value, "upperNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumLessThan(String value) {
            addCriterion("upper_num <", value, "upperNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumLessThanOrEqualTo(String value) {
            addCriterion("upper_num <=", value, "upperNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumLike(String value) {
            addCriterion("upper_num like", value, "upperNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumNotLike(String value) {
            addCriterion("upper_num not like", value, "upperNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumIn(List<String> values) {
            addCriterion("upper_num in", values, "upperNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumNotIn(List<String> values) {
            addCriterion("upper_num not in", values, "upperNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumBetween(String value1, String value2) {
            addCriterion("upper_num between", value1, value2, "upperNum");
            return (Criteria) this;
        }

        public Criteria andUpperNumNotBetween(String value1, String value2) {
            addCriterion("upper_num not between", value1, value2, "upperNum");
            return (Criteria) this;
        }

        public Criteria andFixedChargeIsNull() {
            addCriterion("fixed_charge is null");
            return (Criteria) this;
        }

        public Criteria andFixedChargeIsNotNull() {
            addCriterion("fixed_charge is not null");
            return (Criteria) this;
        }

        public Criteria andFixedChargeEqualTo(String value) {
            addCriterion("fixed_charge =", value, "fixedCharge");
            return (Criteria) this;
        }

        public Criteria andFixedChargeNotEqualTo(String value) {
            addCriterion("fixed_charge <>", value, "fixedCharge");
            return (Criteria) this;
        }

        public Criteria andFixedChargeGreaterThan(String value) {
            addCriterion("fixed_charge >", value, "fixedCharge");
            return (Criteria) this;
        }

        public Criteria andFixedChargeGreaterThanOrEqualTo(String value) {
            addCriterion("fixed_charge >=", value, "fixedCharge");
            return (Criteria) this;
        }

        public Criteria andFixedChargeLessThan(String value) {
            addCriterion("fixed_charge <", value, "fixedCharge");
            return (Criteria) this;
        }

        public Criteria andFixedChargeLessThanOrEqualTo(String value) {
            addCriterion("fixed_charge <=", value, "fixedCharge");
            return (Criteria) this;
        }

        public Criteria andFixedChargeLike(String value) {
            addCriterion("fixed_charge like", value, "fixedCharge");
            return (Criteria) this;
        }

        public Criteria andFixedChargeNotLike(String value) {
            addCriterion("fixed_charge not like", value, "fixedCharge");
            return (Criteria) this;
        }

        public Criteria andFixedChargeIn(List<String> values) {
            addCriterion("fixed_charge in", values, "fixedCharge");
            return (Criteria) this;
        }

        public Criteria andFixedChargeNotIn(List<String> values) {
            addCriterion("fixed_charge not in", values, "fixedCharge");
            return (Criteria) this;
        }

        public Criteria andFixedChargeBetween(String value1, String value2) {
            addCriterion("fixed_charge between", value1, value2, "fixedCharge");
            return (Criteria) this;
        }

        public Criteria andFixedChargeNotBetween(String value1, String value2) {
            addCriterion("fixed_charge not between", value1, value2, "fixedCharge");
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

        public Criteria andHighBatchHandleIsNull() {
            addCriterion("high_batch_handle is null");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleIsNotNull() {
            addCriterion("high_batch_handle is not null");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleEqualTo(String value) {
            addCriterion("high_batch_handle =", value, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleNotEqualTo(String value) {
            addCriterion("high_batch_handle <>", value, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleGreaterThan(String value) {
            addCriterion("high_batch_handle >", value, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleGreaterThanOrEqualTo(String value) {
            addCriterion("high_batch_handle >=", value, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleLessThan(String value) {
            addCriterion("high_batch_handle <", value, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleLessThanOrEqualTo(String value) {
            addCriterion("high_batch_handle <=", value, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleLike(String value) {
            addCriterion("high_batch_handle like", value, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleNotLike(String value) {
            addCriterion("high_batch_handle not like", value, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleIn(List<String> values) {
            addCriterion("high_batch_handle in", values, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleNotIn(List<String> values) {
            addCriterion("high_batch_handle not in", values, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleBetween(String value1, String value2) {
            addCriterion("high_batch_handle between", value1, value2, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andHighBatchHandleNotBetween(String value1, String value2) {
            addCriterion("high_batch_handle not between", value1, value2, "highBatchHandle");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(String value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(String value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(String value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(String value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(String value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(String value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLike(String value) {
            addCriterion("is_del like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotLike(String value) {
            addCriterion("is_del not like", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<String> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<String> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(String value1, String value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(String value1, String value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
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