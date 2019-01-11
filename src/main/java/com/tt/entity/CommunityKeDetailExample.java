package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityKeDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String groupByClause;

    public CommunityKeDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public void setGroupByClause(String groupByClause) {
        this.groupByClause = groupByClause;
    }

    public String getGroupByClause() {
        return groupByClause;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
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

        public Criteria andAliasIsNull() {
            addCriterion("alias is null");
            return (Criteria) this;
        }

        public Criteria andAliasIsNotNull() {
            addCriterion("alias is not null");
            return (Criteria) this;
        }

        public Criteria andAliasEqualTo(String value) {
            addCriterion("alias =", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotEqualTo(String value) {
            addCriterion("alias <>", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThan(String value) {
            addCriterion("alias >", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThanOrEqualTo(String value) {
            addCriterion("alias >=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThan(String value) {
            addCriterion("alias <", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThanOrEqualTo(String value) {
            addCriterion("alias <=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLike(String value) {
            addCriterion("alias like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotLike(String value) {
            addCriterion("alias not like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasIn(List<String> values) {
            addCriterion("alias in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotIn(List<String> values) {
            addCriterion("alias not in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasBetween(String value1, String value2) {
            addCriterion("alias between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotBetween(String value1, String value2) {
            addCriterion("alias not between", value1, value2, "alias");
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

        public Criteria andCityCodeIsNull() {
            addCriterion("city_code is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("city_code <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("city_code like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("city_code not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("city_code not between", value1, value2, "cityCode");
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

        public Criteria andRegionCodeIsNull() {
            addCriterion("region_code is null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIsNotNull() {
            addCriterion("region_code is not null");
            return (Criteria) this;
        }

        public Criteria andRegionCodeEqualTo(String value) {
            addCriterion("region_code =", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotEqualTo(String value) {
            addCriterion("region_code <>", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThan(String value) {
            addCriterion("region_code >", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("region_code >=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThan(String value) {
            addCriterion("region_code <", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLessThanOrEqualTo(String value) {
            addCriterion("region_code <=", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeLike(String value) {
            addCriterion("region_code like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotLike(String value) {
            addCriterion("region_code not like", value, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeIn(List<String> values) {
            addCriterion("region_code in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotIn(List<String> values) {
            addCriterion("region_code not in", values, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeBetween(String value1, String value2) {
            addCriterion("region_code between", value1, value2, "regionCode");
            return (Criteria) this;
        }

        public Criteria andRegionCodeNotBetween(String value1, String value2) {
            addCriterion("region_code not between", value1, value2, "regionCode");
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

        public Criteria andPlateCodeIsNull() {
            addCriterion("plate_code is null");
            return (Criteria) this;
        }

        public Criteria andPlateCodeIsNotNull() {
            addCriterion("plate_code is not null");
            return (Criteria) this;
        }

        public Criteria andPlateCodeEqualTo(String value) {
            addCriterion("plate_code =", value, "plateCode");
            return (Criteria) this;
        }

        public Criteria andPlateCodeNotEqualTo(String value) {
            addCriterion("plate_code <>", value, "plateCode");
            return (Criteria) this;
        }

        public Criteria andPlateCodeGreaterThan(String value) {
            addCriterion("plate_code >", value, "plateCode");
            return (Criteria) this;
        }

        public Criteria andPlateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("plate_code >=", value, "plateCode");
            return (Criteria) this;
        }

        public Criteria andPlateCodeLessThan(String value) {
            addCriterion("plate_code <", value, "plateCode");
            return (Criteria) this;
        }

        public Criteria andPlateCodeLessThanOrEqualTo(String value) {
            addCriterion("plate_code <=", value, "plateCode");
            return (Criteria) this;
        }

        public Criteria andPlateCodeLike(String value) {
            addCriterion("plate_code like", value, "plateCode");
            return (Criteria) this;
        }

        public Criteria andPlateCodeNotLike(String value) {
            addCriterion("plate_code not like", value, "plateCode");
            return (Criteria) this;
        }

        public Criteria andPlateCodeIn(List<String> values) {
            addCriterion("plate_code in", values, "plateCode");
            return (Criteria) this;
        }

        public Criteria andPlateCodeNotIn(List<String> values) {
            addCriterion("plate_code not in", values, "plateCode");
            return (Criteria) this;
        }

        public Criteria andPlateCodeBetween(String value1, String value2) {
            addCriterion("plate_code between", value1, value2, "plateCode");
            return (Criteria) this;
        }

        public Criteria andPlateCodeNotBetween(String value1, String value2) {
            addCriterion("plate_code not between", value1, value2, "plateCode");
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

        public Criteria andSurfacePlotIsNull() {
            addCriterion("surface_plot is null");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotIsNotNull() {
            addCriterion("surface_plot is not null");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotEqualTo(String value) {
            addCriterion("surface_plot =", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotNotEqualTo(String value) {
            addCriterion("surface_plot <>", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotGreaterThan(String value) {
            addCriterion("surface_plot >", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotGreaterThanOrEqualTo(String value) {
            addCriterion("surface_plot >=", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotLessThan(String value) {
            addCriterion("surface_plot <", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotLessThanOrEqualTo(String value) {
            addCriterion("surface_plot <=", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotLike(String value) {
            addCriterion("surface_plot like", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotNotLike(String value) {
            addCriterion("surface_plot not like", value, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotIn(List<String> values) {
            addCriterion("surface_plot in", values, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotNotIn(List<String> values) {
            addCriterion("surface_plot not in", values, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotBetween(String value1, String value2) {
            addCriterion("surface_plot between", value1, value2, "surfacePlot");
            return (Criteria) this;
        }

        public Criteria andSurfacePlotNotBetween(String value1, String value2) {
            addCriterion("surface_plot not between", value1, value2, "surfacePlot");
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

        public Criteria andTradingRightsIsNull() {
            addCriterion("trading_rights is null");
            return (Criteria) this;
        }

        public Criteria andTradingRightsIsNotNull() {
            addCriterion("trading_rights is not null");
            return (Criteria) this;
        }

        public Criteria andTradingRightsEqualTo(String value) {
            addCriterion("trading_rights =", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsNotEqualTo(String value) {
            addCriterion("trading_rights <>", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsGreaterThan(String value) {
            addCriterion("trading_rights >", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsGreaterThanOrEqualTo(String value) {
            addCriterion("trading_rights >=", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsLessThan(String value) {
            addCriterion("trading_rights <", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsLessThanOrEqualTo(String value) {
            addCriterion("trading_rights <=", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsLike(String value) {
            addCriterion("trading_rights like", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsNotLike(String value) {
            addCriterion("trading_rights not like", value, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsIn(List<String> values) {
            addCriterion("trading_rights in", values, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsNotIn(List<String> values) {
            addCriterion("trading_rights not in", values, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsBetween(String value1, String value2) {
            addCriterion("trading_rights between", value1, value2, "tradingRights");
            return (Criteria) this;
        }

        public Criteria andTradingRightsNotBetween(String value1, String value2) {
            addCriterion("trading_rights not between", value1, value2, "tradingRights");
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

        public Criteria andHeatingCostIsNull() {
            addCriterion("heating_cost is null");
            return (Criteria) this;
        }

        public Criteria andHeatingCostIsNotNull() {
            addCriterion("heating_cost is not null");
            return (Criteria) this;
        }

        public Criteria andHeatingCostEqualTo(String value) {
            addCriterion("heating_cost =", value, "heatingCost");
            return (Criteria) this;
        }

        public Criteria andHeatingCostNotEqualTo(String value) {
            addCriterion("heating_cost <>", value, "heatingCost");
            return (Criteria) this;
        }

        public Criteria andHeatingCostGreaterThan(String value) {
            addCriterion("heating_cost >", value, "heatingCost");
            return (Criteria) this;
        }

        public Criteria andHeatingCostGreaterThanOrEqualTo(String value) {
            addCriterion("heating_cost >=", value, "heatingCost");
            return (Criteria) this;
        }

        public Criteria andHeatingCostLessThan(String value) {
            addCriterion("heating_cost <", value, "heatingCost");
            return (Criteria) this;
        }

        public Criteria andHeatingCostLessThanOrEqualTo(String value) {
            addCriterion("heating_cost <=", value, "heatingCost");
            return (Criteria) this;
        }

        public Criteria andHeatingCostLike(String value) {
            addCriterion("heating_cost like", value, "heatingCost");
            return (Criteria) this;
        }

        public Criteria andHeatingCostNotLike(String value) {
            addCriterion("heating_cost not like", value, "heatingCost");
            return (Criteria) this;
        }

        public Criteria andHeatingCostIn(List<String> values) {
            addCriterion("heating_cost in", values, "heatingCost");
            return (Criteria) this;
        }

        public Criteria andHeatingCostNotIn(List<String> values) {
            addCriterion("heating_cost not in", values, "heatingCost");
            return (Criteria) this;
        }

        public Criteria andHeatingCostBetween(String value1, String value2) {
            addCriterion("heating_cost between", value1, value2, "heatingCost");
            return (Criteria) this;
        }

        public Criteria andHeatingCostNotBetween(String value1, String value2) {
            addCriterion("heating_cost not between", value1, value2, "heatingCost");
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

        public Criteria andUsesIsNull() {
            addCriterion("uses is null");
            return (Criteria) this;
        }

        public Criteria andUsesIsNotNull() {
            addCriterion("uses is not null");
            return (Criteria) this;
        }

        public Criteria andUsesEqualTo(String value) {
            addCriterion("uses =", value, "uses");
            return (Criteria) this;
        }

        public Criteria andUsesNotEqualTo(String value) {
            addCriterion("uses <>", value, "uses");
            return (Criteria) this;
        }

        public Criteria andUsesGreaterThan(String value) {
            addCriterion("uses >", value, "uses");
            return (Criteria) this;
        }

        public Criteria andUsesGreaterThanOrEqualTo(String value) {
            addCriterion("uses >=", value, "uses");
            return (Criteria) this;
        }

        public Criteria andUsesLessThan(String value) {
            addCriterion("uses <", value, "uses");
            return (Criteria) this;
        }

        public Criteria andUsesLessThanOrEqualTo(String value) {
            addCriterion("uses <=", value, "uses");
            return (Criteria) this;
        }

        public Criteria andUsesLike(String value) {
            addCriterion("uses like", value, "uses");
            return (Criteria) this;
        }

        public Criteria andUsesNotLike(String value) {
            addCriterion("uses not like", value, "uses");
            return (Criteria) this;
        }

        public Criteria andUsesIn(List<String> values) {
            addCriterion("uses in", values, "uses");
            return (Criteria) this;
        }

        public Criteria andUsesNotIn(List<String> values) {
            addCriterion("uses not in", values, "uses");
            return (Criteria) this;
        }

        public Criteria andUsesBetween(String value1, String value2) {
            addCriterion("uses between", value1, value2, "uses");
            return (Criteria) this;
        }

        public Criteria andUsesNotBetween(String value1, String value2) {
            addCriterion("uses not between", value1, value2, "uses");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlIsNull() {
            addCriterion("loudong_url is null");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlIsNotNull() {
            addCriterion("loudong_url is not null");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlEqualTo(String value) {
            addCriterion("loudong_url =", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlNotEqualTo(String value) {
            addCriterion("loudong_url <>", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlGreaterThan(String value) {
            addCriterion("loudong_url >", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlGreaterThanOrEqualTo(String value) {
            addCriterion("loudong_url >=", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlLessThan(String value) {
            addCriterion("loudong_url <", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlLessThanOrEqualTo(String value) {
            addCriterion("loudong_url <=", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlLike(String value) {
            addCriterion("loudong_url like", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlNotLike(String value) {
            addCriterion("loudong_url not like", value, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlIn(List<String> values) {
            addCriterion("loudong_url in", values, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlNotIn(List<String> values) {
            addCriterion("loudong_url not in", values, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlBetween(String value1, String value2) {
            addCriterion("loudong_url between", value1, value2, "loudongUrl");
            return (Criteria) this;
        }

        public Criteria andLoudongUrlNotBetween(String value1, String value2) {
            addCriterion("loudong_url not between", value1, value2, "loudongUrl");
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

        public Criteria andRailwayAdressIsNull() {
            addCriterion("railway_adress is null");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressIsNotNull() {
            addCriterion("railway_adress is not null");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressEqualTo(String value) {
            addCriterion("railway_adress =", value, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressNotEqualTo(String value) {
            addCriterion("railway_adress <>", value, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressGreaterThan(String value) {
            addCriterion("railway_adress >", value, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressGreaterThanOrEqualTo(String value) {
            addCriterion("railway_adress >=", value, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressLessThan(String value) {
            addCriterion("railway_adress <", value, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressLessThanOrEqualTo(String value) {
            addCriterion("railway_adress <=", value, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressLike(String value) {
            addCriterion("railway_adress like", value, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressNotLike(String value) {
            addCriterion("railway_adress not like", value, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressIn(List<String> values) {
            addCriterion("railway_adress in", values, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressNotIn(List<String> values) {
            addCriterion("railway_adress not in", values, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressBetween(String value1, String value2) {
            addCriterion("railway_adress between", value1, value2, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andRailwayAdressNotBetween(String value1, String value2) {
            addCriterion("railway_adress not between", value1, value2, "railwayAdress");
            return (Criteria) this;
        }

        public Criteria andNumForSaleIsNull() {
            addCriterion("num_for_sale is null");
            return (Criteria) this;
        }

        public Criteria andNumForSaleIsNotNull() {
            addCriterion("num_for_sale is not null");
            return (Criteria) this;
        }

        public Criteria andNumForSaleEqualTo(String value) {
            addCriterion("num_for_sale =", value, "numForSale");
            return (Criteria) this;
        }

        public Criteria andNumForSaleNotEqualTo(String value) {
            addCriterion("num_for_sale <>", value, "numForSale");
            return (Criteria) this;
        }

        public Criteria andNumForSaleGreaterThan(String value) {
            addCriterion("num_for_sale >", value, "numForSale");
            return (Criteria) this;
        }

        public Criteria andNumForSaleGreaterThanOrEqualTo(String value) {
            addCriterion("num_for_sale >=", value, "numForSale");
            return (Criteria) this;
        }

        public Criteria andNumForSaleLessThan(String value) {
            addCriterion("num_for_sale <", value, "numForSale");
            return (Criteria) this;
        }

        public Criteria andNumForSaleLessThanOrEqualTo(String value) {
            addCriterion("num_for_sale <=", value, "numForSale");
            return (Criteria) this;
        }

        public Criteria andNumForSaleLike(String value) {
            addCriterion("num_for_sale like", value, "numForSale");
            return (Criteria) this;
        }

        public Criteria andNumForSaleNotLike(String value) {
            addCriterion("num_for_sale not like", value, "numForSale");
            return (Criteria) this;
        }

        public Criteria andNumForSaleIn(List<String> values) {
            addCriterion("num_for_sale in", values, "numForSale");
            return (Criteria) this;
        }

        public Criteria andNumForSaleNotIn(List<String> values) {
            addCriterion("num_for_sale not in", values, "numForSale");
            return (Criteria) this;
        }

        public Criteria andNumForSaleBetween(String value1, String value2) {
            addCriterion("num_for_sale between", value1, value2, "numForSale");
            return (Criteria) this;
        }

        public Criteria andNumForSaleNotBetween(String value1, String value2) {
            addCriterion("num_for_sale not between", value1, value2, "numForSale");
            return (Criteria) this;
        }

        public Criteria andRentNumIsNull() {
            addCriterion("rent_num is null");
            return (Criteria) this;
        }

        public Criteria andRentNumIsNotNull() {
            addCriterion("rent_num is not null");
            return (Criteria) this;
        }

        public Criteria andRentNumEqualTo(String value) {
            addCriterion("rent_num =", value, "rentNum");
            return (Criteria) this;
        }

        public Criteria andRentNumNotEqualTo(String value) {
            addCriterion("rent_num <>", value, "rentNum");
            return (Criteria) this;
        }

        public Criteria andRentNumGreaterThan(String value) {
            addCriterion("rent_num >", value, "rentNum");
            return (Criteria) this;
        }

        public Criteria andRentNumGreaterThanOrEqualTo(String value) {
            addCriterion("rent_num >=", value, "rentNum");
            return (Criteria) this;
        }

        public Criteria andRentNumLessThan(String value) {
            addCriterion("rent_num <", value, "rentNum");
            return (Criteria) this;
        }

        public Criteria andRentNumLessThanOrEqualTo(String value) {
            addCriterion("rent_num <=", value, "rentNum");
            return (Criteria) this;
        }

        public Criteria andRentNumLike(String value) {
            addCriterion("rent_num like", value, "rentNum");
            return (Criteria) this;
        }

        public Criteria andRentNumNotLike(String value) {
            addCriterion("rent_num not like", value, "rentNum");
            return (Criteria) this;
        }

        public Criteria andRentNumIn(List<String> values) {
            addCriterion("rent_num in", values, "rentNum");
            return (Criteria) this;
        }

        public Criteria andRentNumNotIn(List<String> values) {
            addCriterion("rent_num not in", values, "rentNum");
            return (Criteria) this;
        }

        public Criteria andRentNumBetween(String value1, String value2) {
            addCriterion("rent_num between", value1, value2, "rentNum");
            return (Criteria) this;
        }

        public Criteria andRentNumNotBetween(String value1, String value2) {
            addCriterion("rent_num not between", value1, value2, "rentNum");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
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