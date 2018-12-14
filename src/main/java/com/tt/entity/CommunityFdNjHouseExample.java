package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommunityFdNjHouseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommunityFdNjHouseExample() {
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

        public Criteria andBuildingIdIsNull() {
            addCriterion("building_id is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("building_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(String value) {
            addCriterion("building_id =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(String value) {
            addCriterion("building_id <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(String value) {
            addCriterion("building_id >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(String value) {
            addCriterion("building_id >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(String value) {
            addCriterion("building_id <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(String value) {
            addCriterion("building_id <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLike(String value) {
            addCriterion("building_id like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotLike(String value) {
            addCriterion("building_id not like", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<String> values) {
            addCriterion("building_id in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<String> values) {
            addCriterion("building_id not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(String value1, String value2) {
            addCriterion("building_id between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(String value1, String value2) {
            addCriterion("building_id not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andHouseUrlIsNull() {
            addCriterion("house_url is null");
            return (Criteria) this;
        }

        public Criteria andHouseUrlIsNotNull() {
            addCriterion("house_url is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUrlEqualTo(String value) {
            addCriterion("house_url =", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlNotEqualTo(String value) {
            addCriterion("house_url <>", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlGreaterThan(String value) {
            addCriterion("house_url >", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlGreaterThanOrEqualTo(String value) {
            addCriterion("house_url >=", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlLessThan(String value) {
            addCriterion("house_url <", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlLessThanOrEqualTo(String value) {
            addCriterion("house_url <=", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlLike(String value) {
            addCriterion("house_url like", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlNotLike(String value) {
            addCriterion("house_url not like", value, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlIn(List<String> values) {
            addCriterion("house_url in", values, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlNotIn(List<String> values) {
            addCriterion("house_url not in", values, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlBetween(String value1, String value2) {
            addCriterion("house_url between", value1, value2, "houseUrl");
            return (Criteria) this;
        }

        public Criteria andHouseUrlNotBetween(String value1, String value2) {
            addCriterion("house_url not between", value1, value2, "houseUrl");
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

        public Criteria andHouseIdIsNull() {
            addCriterion("house_id is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNotNull() {
            addCriterion("house_id is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdEqualTo(String value) {
            addCriterion("house_id =", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotEqualTo(String value) {
            addCriterion("house_id <>", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThan(String value) {
            addCriterion("house_id >", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("house_id >=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThan(String value) {
            addCriterion("house_id <", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThanOrEqualTo(String value) {
            addCriterion("house_id <=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLike(String value) {
            addCriterion("house_id like", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotLike(String value) {
            addCriterion("house_id not like", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIn(List<String> values) {
            addCriterion("house_id in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotIn(List<String> values) {
            addCriterion("house_id not in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdBetween(String value1, String value2) {
            addCriterion("house_id between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotBetween(String value1, String value2) {
            addCriterion("house_id not between", value1, value2, "houseId");
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andIsSaleIsNull() {
            addCriterion("is_sale is null");
            return (Criteria) this;
        }

        public Criteria andIsSaleIsNotNull() {
            addCriterion("is_sale is not null");
            return (Criteria) this;
        }

        public Criteria andIsSaleEqualTo(String value) {
            addCriterion("is_sale =", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleNotEqualTo(String value) {
            addCriterion("is_sale <>", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleGreaterThan(String value) {
            addCriterion("is_sale >", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleGreaterThanOrEqualTo(String value) {
            addCriterion("is_sale >=", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleLessThan(String value) {
            addCriterion("is_sale <", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleLessThanOrEqualTo(String value) {
            addCriterion("is_sale <=", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleLike(String value) {
            addCriterion("is_sale like", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleNotLike(String value) {
            addCriterion("is_sale not like", value, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleIn(List<String> values) {
            addCriterion("is_sale in", values, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleNotIn(List<String> values) {
            addCriterion("is_sale not in", values, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleBetween(String value1, String value2) {
            addCriterion("is_sale between", value1, value2, "isSale");
            return (Criteria) this;
        }

        public Criteria andIsSaleNotBetween(String value1, String value2) {
            addCriterion("is_sale not between", value1, value2, "isSale");
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