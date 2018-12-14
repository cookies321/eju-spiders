package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityFdHzHouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityFdHzHouseExample() {
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

        public Criteria andBuildingIsNull() {
            addCriterion("building is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIsNotNull() {
            addCriterion("building is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingEqualTo(String value) {
            addCriterion("building =", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotEqualTo(String value) {
            addCriterion("building <>", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingGreaterThan(String value) {
            addCriterion("building >", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingGreaterThanOrEqualTo(String value) {
            addCriterion("building >=", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLessThan(String value) {
            addCriterion("building <", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLessThanOrEqualTo(String value) {
            addCriterion("building <=", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLike(String value) {
            addCriterion("building like", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotLike(String value) {
            addCriterion("building not like", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingIn(List<String> values) {
            addCriterion("building in", values, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotIn(List<String> values) {
            addCriterion("building not in", values, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingBetween(String value1, String value2) {
            addCriterion("building between", value1, value2, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotBetween(String value1, String value2) {
            addCriterion("building not between", value1, value2, "building");
            return (Criteria) this;
        }

        public Criteria andUnitNumIsNull() {
            addCriterion("unit_num is null");
            return (Criteria) this;
        }

        public Criteria andUnitNumIsNotNull() {
            addCriterion("unit_num is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNumEqualTo(String value) {
            addCriterion("unit_num =", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotEqualTo(String value) {
            addCriterion("unit_num <>", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumGreaterThan(String value) {
            addCriterion("unit_num >", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumGreaterThanOrEqualTo(String value) {
            addCriterion("unit_num >=", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLessThan(String value) {
            addCriterion("unit_num <", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLessThanOrEqualTo(String value) {
            addCriterion("unit_num <=", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumLike(String value) {
            addCriterion("unit_num like", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotLike(String value) {
            addCriterion("unit_num not like", value, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumIn(List<String> values) {
            addCriterion("unit_num in", values, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotIn(List<String> values) {
            addCriterion("unit_num not in", values, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumBetween(String value1, String value2) {
            addCriterion("unit_num between", value1, value2, "unitNum");
            return (Criteria) this;
        }

        public Criteria andUnitNumNotBetween(String value1, String value2) {
            addCriterion("unit_num not between", value1, value2, "unitNum");
            return (Criteria) this;
        }

        public Criteria andHouseNameIsNull() {
            addCriterion("house_name is null");
            return (Criteria) this;
        }

        public Criteria andHouseNameIsNotNull() {
            addCriterion("house_name is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNameEqualTo(String value) {
            addCriterion("house_name =", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotEqualTo(String value) {
            addCriterion("house_name <>", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameGreaterThan(String value) {
            addCriterion("house_name >", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("house_name >=", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLessThan(String value) {
            addCriterion("house_name <", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLessThanOrEqualTo(String value) {
            addCriterion("house_name <=", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameLike(String value) {
            addCriterion("house_name like", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotLike(String value) {
            addCriterion("house_name not like", value, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameIn(List<String> values) {
            addCriterion("house_name in", values, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotIn(List<String> values) {
            addCriterion("house_name not in", values, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameBetween(String value1, String value2) {
            addCriterion("house_name between", value1, value2, "houseName");
            return (Criteria) this;
        }

        public Criteria andHouseNameNotBetween(String value1, String value2) {
            addCriterion("house_name not between", value1, value2, "houseName");
            return (Criteria) this;
        }

        public Criteria andLayoutIsNull() {
            addCriterion("layout is null");
            return (Criteria) this;
        }

        public Criteria andLayoutIsNotNull() {
            addCriterion("layout is not null");
            return (Criteria) this;
        }

        public Criteria andLayoutEqualTo(String value) {
            addCriterion("layout =", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotEqualTo(String value) {
            addCriterion("layout <>", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutGreaterThan(String value) {
            addCriterion("layout >", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutGreaterThanOrEqualTo(String value) {
            addCriterion("layout >=", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutLessThan(String value) {
            addCriterion("layout <", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutLessThanOrEqualTo(String value) {
            addCriterion("layout <=", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutLike(String value) {
            addCriterion("layout like", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotLike(String value) {
            addCriterion("layout not like", value, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutIn(List<String> values) {
            addCriterion("layout in", values, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotIn(List<String> values) {
            addCriterion("layout not in", values, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutBetween(String value1, String value2) {
            addCriterion("layout between", value1, value2, "layout");
            return (Criteria) this;
        }

        public Criteria andLayoutNotBetween(String value1, String value2) {
            addCriterion("layout not between", value1, value2, "layout");
            return (Criteria) this;
        }

        public Criteria andRealFloorIsNull() {
            addCriterion("real_floor is null");
            return (Criteria) this;
        }

        public Criteria andRealFloorIsNotNull() {
            addCriterion("real_floor is not null");
            return (Criteria) this;
        }

        public Criteria andRealFloorEqualTo(String value) {
            addCriterion("real_floor =", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorNotEqualTo(String value) {
            addCriterion("real_floor <>", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorGreaterThan(String value) {
            addCriterion("real_floor >", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorGreaterThanOrEqualTo(String value) {
            addCriterion("real_floor >=", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorLessThan(String value) {
            addCriterion("real_floor <", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorLessThanOrEqualTo(String value) {
            addCriterion("real_floor <=", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorLike(String value) {
            addCriterion("real_floor like", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorNotLike(String value) {
            addCriterion("real_floor not like", value, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorIn(List<String> values) {
            addCriterion("real_floor in", values, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorNotIn(List<String> values) {
            addCriterion("real_floor not in", values, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorBetween(String value1, String value2) {
            addCriterion("real_floor between", value1, value2, "realFloor");
            return (Criteria) this;
        }

        public Criteria andRealFloorNotBetween(String value1, String value2) {
            addCriterion("real_floor not between", value1, value2, "realFloor");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaIsNull() {
            addCriterion("predicted_area is null");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaIsNotNull() {
            addCriterion("predicted_area is not null");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaEqualTo(String value) {
            addCriterion("predicted_area =", value, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaNotEqualTo(String value) {
            addCriterion("predicted_area <>", value, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaGreaterThan(String value) {
            addCriterion("predicted_area >", value, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaGreaterThanOrEqualTo(String value) {
            addCriterion("predicted_area >=", value, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaLessThan(String value) {
            addCriterion("predicted_area <", value, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaLessThanOrEqualTo(String value) {
            addCriterion("predicted_area <=", value, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaLike(String value) {
            addCriterion("predicted_area like", value, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaNotLike(String value) {
            addCriterion("predicted_area not like", value, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaIn(List<String> values) {
            addCriterion("predicted_area in", values, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaNotIn(List<String> values) {
            addCriterion("predicted_area not in", values, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaBetween(String value1, String value2) {
            addCriterion("predicted_area between", value1, value2, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andPredictedAreaNotBetween(String value1, String value2) {
            addCriterion("predicted_area not between", value1, value2, "predictedArea");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceIsNull() {
            addCriterion("dwelling_floor_space is null");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceIsNotNull() {
            addCriterion("dwelling_floor_space is not null");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceEqualTo(String value) {
            addCriterion("dwelling_floor_space =", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceNotEqualTo(String value) {
            addCriterion("dwelling_floor_space <>", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceGreaterThan(String value) {
            addCriterion("dwelling_floor_space >", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceGreaterThanOrEqualTo(String value) {
            addCriterion("dwelling_floor_space >=", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceLessThan(String value) {
            addCriterion("dwelling_floor_space <", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceLessThanOrEqualTo(String value) {
            addCriterion("dwelling_floor_space <=", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceLike(String value) {
            addCriterion("dwelling_floor_space like", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceNotLike(String value) {
            addCriterion("dwelling_floor_space not like", value, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceIn(List<String> values) {
            addCriterion("dwelling_floor_space in", values, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceNotIn(List<String> values) {
            addCriterion("dwelling_floor_space not in", values, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceBetween(String value1, String value2) {
            addCriterion("dwelling_floor_space between", value1, value2, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andDwellingFloorSpaceNotBetween(String value1, String value2) {
            addCriterion("dwelling_floor_space not between", value1, value2, "dwellingFloorSpace");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaIsNull() {
            addCriterion("shared_building_area is null");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaIsNotNull() {
            addCriterion("shared_building_area is not null");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaEqualTo(String value) {
            addCriterion("shared_building_area =", value, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaNotEqualTo(String value) {
            addCriterion("shared_building_area <>", value, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaGreaterThan(String value) {
            addCriterion("shared_building_area >", value, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaGreaterThanOrEqualTo(String value) {
            addCriterion("shared_building_area >=", value, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaLessThan(String value) {
            addCriterion("shared_building_area <", value, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaLessThanOrEqualTo(String value) {
            addCriterion("shared_building_area <=", value, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaLike(String value) {
            addCriterion("shared_building_area like", value, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaNotLike(String value) {
            addCriterion("shared_building_area not like", value, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaIn(List<String> values) {
            addCriterion("shared_building_area in", values, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaNotIn(List<String> values) {
            addCriterion("shared_building_area not in", values, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaBetween(String value1, String value2) {
            addCriterion("shared_building_area between", value1, value2, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andSharedBuildingAreaNotBetween(String value1, String value2) {
            addCriterion("shared_building_area not between", value1, value2, "sharedBuildingArea");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceIsNull() {
            addCriterion("maopi_price is null");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceIsNotNull() {
            addCriterion("maopi_price is not null");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceEqualTo(String value) {
            addCriterion("maopi_price =", value, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceNotEqualTo(String value) {
            addCriterion("maopi_price <>", value, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceGreaterThan(String value) {
            addCriterion("maopi_price >", value, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceGreaterThanOrEqualTo(String value) {
            addCriterion("maopi_price >=", value, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceLessThan(String value) {
            addCriterion("maopi_price <", value, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceLessThanOrEqualTo(String value) {
            addCriterion("maopi_price <=", value, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceLike(String value) {
            addCriterion("maopi_price like", value, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceNotLike(String value) {
            addCriterion("maopi_price not like", value, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceIn(List<String> values) {
            addCriterion("maopi_price in", values, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceNotIn(List<String> values) {
            addCriterion("maopi_price not in", values, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceBetween(String value1, String value2) {
            addCriterion("maopi_price between", value1, value2, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andMaopiPriceNotBetween(String value1, String value2) {
            addCriterion("maopi_price not between", value1, value2, "maopiPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceIsNull() {
            addCriterion("renovation_price is null");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceIsNotNull() {
            addCriterion("renovation_price is not null");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceEqualTo(String value) {
            addCriterion("renovation_price =", value, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceNotEqualTo(String value) {
            addCriterion("renovation_price <>", value, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceGreaterThan(String value) {
            addCriterion("renovation_price >", value, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceGreaterThanOrEqualTo(String value) {
            addCriterion("renovation_price >=", value, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceLessThan(String value) {
            addCriterion("renovation_price <", value, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceLessThanOrEqualTo(String value) {
            addCriterion("renovation_price <=", value, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceLike(String value) {
            addCriterion("renovation_price like", value, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceNotLike(String value) {
            addCriterion("renovation_price not like", value, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceIn(List<String> values) {
            addCriterion("renovation_price in", values, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceNotIn(List<String> values) {
            addCriterion("renovation_price not in", values, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceBetween(String value1, String value2) {
            addCriterion("renovation_price between", value1, value2, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andRenovationPriceNotBetween(String value1, String value2) {
            addCriterion("renovation_price not between", value1, value2, "renovationPrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNull() {
            addCriterion("sale_price is null");
            return (Criteria) this;
        }

        public Criteria andSalePriceIsNotNull() {
            addCriterion("sale_price is not null");
            return (Criteria) this;
        }

        public Criteria andSalePriceEqualTo(String value) {
            addCriterion("sale_price =", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotEqualTo(String value) {
            addCriterion("sale_price <>", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThan(String value) {
            addCriterion("sale_price >", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceGreaterThanOrEqualTo(String value) {
            addCriterion("sale_price >=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThan(String value) {
            addCriterion("sale_price <", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLessThanOrEqualTo(String value) {
            addCriterion("sale_price <=", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceLike(String value) {
            addCriterion("sale_price like", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotLike(String value) {
            addCriterion("sale_price not like", value, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceIn(List<String> values) {
            addCriterion("sale_price in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotIn(List<String> values) {
            addCriterion("sale_price not in", values, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceBetween(String value1, String value2) {
            addCriterion("sale_price between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andSalePriceNotBetween(String value1, String value2) {
            addCriterion("sale_price not between", value1, value2, "salePrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(String value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(String value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(String value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(String value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLike(String value) {
            addCriterion("total_price like", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotLike(String value) {
            addCriterion("total_price not like", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<String> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<String> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(String value1, String value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(String value1, String value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
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