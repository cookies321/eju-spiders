package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnjukeCommunityListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnjukeCommunityListExample() {
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