package com.tt.entity;

import java.util.ArrayList;
import java.util.List;

public class CommunityKeDetailGaodeAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityKeDetailGaodeAddressExample() {
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

        public Criteria andTitleGaodeIsNull() {
            addCriterion("title_gaode is null");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeIsNotNull() {
            addCriterion("title_gaode is not null");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeEqualTo(String value) {
            addCriterion("title_gaode =", value, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeNotEqualTo(String value) {
            addCriterion("title_gaode <>", value, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeGreaterThan(String value) {
            addCriterion("title_gaode >", value, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeGreaterThanOrEqualTo(String value) {
            addCriterion("title_gaode >=", value, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeLessThan(String value) {
            addCriterion("title_gaode <", value, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeLessThanOrEqualTo(String value) {
            addCriterion("title_gaode <=", value, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeLike(String value) {
            addCriterion("title_gaode like", value, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeNotLike(String value) {
            addCriterion("title_gaode not like", value, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeIn(List<String> values) {
            addCriterion("title_gaode in", values, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeNotIn(List<String> values) {
            addCriterion("title_gaode not in", values, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeBetween(String value1, String value2) {
            addCriterion("title_gaode between", value1, value2, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andTitleGaodeNotBetween(String value1, String value2) {
            addCriterion("title_gaode not between", value1, value2, "titleGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeIsNull() {
            addCriterion("address_gaode is null");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeIsNotNull() {
            addCriterion("address_gaode is not null");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeEqualTo(String value) {
            addCriterion("address_gaode =", value, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeNotEqualTo(String value) {
            addCriterion("address_gaode <>", value, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeGreaterThan(String value) {
            addCriterion("address_gaode >", value, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeGreaterThanOrEqualTo(String value) {
            addCriterion("address_gaode >=", value, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeLessThan(String value) {
            addCriterion("address_gaode <", value, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeLessThanOrEqualTo(String value) {
            addCriterion("address_gaode <=", value, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeLike(String value) {
            addCriterion("address_gaode like", value, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeNotLike(String value) {
            addCriterion("address_gaode not like", value, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeIn(List<String> values) {
            addCriterion("address_gaode in", values, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeNotIn(List<String> values) {
            addCriterion("address_gaode not in", values, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeBetween(String value1, String value2) {
            addCriterion("address_gaode between", value1, value2, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andAddressGaodeNotBetween(String value1, String value2) {
            addCriterion("address_gaode not between", value1, value2, "addressGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeIsNull() {
            addCriterion("location_gaode is null");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeIsNotNull() {
            addCriterion("location_gaode is not null");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeEqualTo(String value) {
            addCriterion("location_gaode =", value, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeNotEqualTo(String value) {
            addCriterion("location_gaode <>", value, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeGreaterThan(String value) {
            addCriterion("location_gaode >", value, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeGreaterThanOrEqualTo(String value) {
            addCriterion("location_gaode >=", value, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeLessThan(String value) {
            addCriterion("location_gaode <", value, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeLessThanOrEqualTo(String value) {
            addCriterion("location_gaode <=", value, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeLike(String value) {
            addCriterion("location_gaode like", value, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeNotLike(String value) {
            addCriterion("location_gaode not like", value, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeIn(List<String> values) {
            addCriterion("location_gaode in", values, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeNotIn(List<String> values) {
            addCriterion("location_gaode not in", values, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeBetween(String value1, String value2) {
            addCriterion("location_gaode between", value1, value2, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andLocationGaodeNotBetween(String value1, String value2) {
            addCriterion("location_gaode not between", value1, value2, "locationGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeIsNull() {
            addCriterion("province_gaode is null");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeIsNotNull() {
            addCriterion("province_gaode is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeEqualTo(String value) {
            addCriterion("province_gaode =", value, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeNotEqualTo(String value) {
            addCriterion("province_gaode <>", value, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeGreaterThan(String value) {
            addCriterion("province_gaode >", value, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_gaode >=", value, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeLessThan(String value) {
            addCriterion("province_gaode <", value, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeLessThanOrEqualTo(String value) {
            addCriterion("province_gaode <=", value, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeLike(String value) {
            addCriterion("province_gaode like", value, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeNotLike(String value) {
            addCriterion("province_gaode not like", value, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeIn(List<String> values) {
            addCriterion("province_gaode in", values, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeNotIn(List<String> values) {
            addCriterion("province_gaode not in", values, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeBetween(String value1, String value2) {
            addCriterion("province_gaode between", value1, value2, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andProvinceGaodeNotBetween(String value1, String value2) {
            addCriterion("province_gaode not between", value1, value2, "provinceGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeIsNull() {
            addCriterion("city_gaode is null");
            return (Criteria) this;
        }

        public Criteria andCityGaodeIsNotNull() {
            addCriterion("city_gaode is not null");
            return (Criteria) this;
        }

        public Criteria andCityGaodeEqualTo(String value) {
            addCriterion("city_gaode =", value, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeNotEqualTo(String value) {
            addCriterion("city_gaode <>", value, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeGreaterThan(String value) {
            addCriterion("city_gaode >", value, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_gaode >=", value, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeLessThan(String value) {
            addCriterion("city_gaode <", value, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeLessThanOrEqualTo(String value) {
            addCriterion("city_gaode <=", value, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeLike(String value) {
            addCriterion("city_gaode like", value, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeNotLike(String value) {
            addCriterion("city_gaode not like", value, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeIn(List<String> values) {
            addCriterion("city_gaode in", values, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeNotIn(List<String> values) {
            addCriterion("city_gaode not in", values, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeBetween(String value1, String value2) {
            addCriterion("city_gaode between", value1, value2, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andCityGaodeNotBetween(String value1, String value2) {
            addCriterion("city_gaode not between", value1, value2, "cityGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeIsNull() {
            addCriterion("region_gaode is null");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeIsNotNull() {
            addCriterion("region_gaode is not null");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeEqualTo(String value) {
            addCriterion("region_gaode =", value, "regionGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeNotEqualTo(String value) {
            addCriterion("region_gaode <>", value, "regionGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeGreaterThan(String value) {
            addCriterion("region_gaode >", value, "regionGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeGreaterThanOrEqualTo(String value) {
            addCriterion("region_gaode >=", value, "regionGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeLessThan(String value) {
            addCriterion("region_gaode <", value, "regionGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeLessThanOrEqualTo(String value) {
            addCriterion("region_gaode <=", value, "regionGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeLike(String value) {
            addCriterion("region_gaode like", value, "regionGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeNotLike(String value) {
            addCriterion("region_gaode not like", value, "regionGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeIn(List<String> values) {
            addCriterion("region_gaode in", values, "regionGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeNotIn(List<String> values) {
            addCriterion("region_gaode not in", values, "regionGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeBetween(String value1, String value2) {
            addCriterion("region_gaode between", value1, value2, "regionGaode");
            return (Criteria) this;
        }

        public Criteria andRegionGaodeNotBetween(String value1, String value2) {
            addCriterion("region_gaode not between", value1, value2, "regionGaode");
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