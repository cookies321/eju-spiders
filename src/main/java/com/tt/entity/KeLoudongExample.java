package com.tt.entity;

import java.util.ArrayList;
import java.util.List;

public class KeLoudongExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KeLoudongExample() {
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

        public Criteria andFrameNumIsNull() {
            addCriterion("frame_num is null");
            return (Criteria) this;
        }

        public Criteria andFrameNumIsNotNull() {
            addCriterion("frame_num is not null");
            return (Criteria) this;
        }

        public Criteria andFrameNumEqualTo(String value) {
            addCriterion("frame_num =", value, "frameNum");
            return (Criteria) this;
        }

        public Criteria andFrameNumNotEqualTo(String value) {
            addCriterion("frame_num <>", value, "frameNum");
            return (Criteria) this;
        }

        public Criteria andFrameNumGreaterThan(String value) {
            addCriterion("frame_num >", value, "frameNum");
            return (Criteria) this;
        }

        public Criteria andFrameNumGreaterThanOrEqualTo(String value) {
            addCriterion("frame_num >=", value, "frameNum");
            return (Criteria) this;
        }

        public Criteria andFrameNumLessThan(String value) {
            addCriterion("frame_num <", value, "frameNum");
            return (Criteria) this;
        }

        public Criteria andFrameNumLessThanOrEqualTo(String value) {
            addCriterion("frame_num <=", value, "frameNum");
            return (Criteria) this;
        }

        public Criteria andFrameNumLike(String value) {
            addCriterion("frame_num like", value, "frameNum");
            return (Criteria) this;
        }

        public Criteria andFrameNumNotLike(String value) {
            addCriterion("frame_num not like", value, "frameNum");
            return (Criteria) this;
        }

        public Criteria andFrameNumIn(List<String> values) {
            addCriterion("frame_num in", values, "frameNum");
            return (Criteria) this;
        }

        public Criteria andFrameNumNotIn(List<String> values) {
            addCriterion("frame_num not in", values, "frameNum");
            return (Criteria) this;
        }

        public Criteria andFrameNumBetween(String value1, String value2) {
            addCriterion("frame_num between", value1, value2, "frameNum");
            return (Criteria) this;
        }

        public Criteria andFrameNumNotBetween(String value1, String value2) {
            addCriterion("frame_num not between", value1, value2, "frameNum");
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

        public Criteria andPointLatIsNull() {
            addCriterion("point_lat is null");
            return (Criteria) this;
        }

        public Criteria andPointLatIsNotNull() {
            addCriterion("point_lat is not null");
            return (Criteria) this;
        }

        public Criteria andPointLatEqualTo(String value) {
            addCriterion("point_lat =", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatNotEqualTo(String value) {
            addCriterion("point_lat <>", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatGreaterThan(String value) {
            addCriterion("point_lat >", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatGreaterThanOrEqualTo(String value) {
            addCriterion("point_lat >=", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatLessThan(String value) {
            addCriterion("point_lat <", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatLessThanOrEqualTo(String value) {
            addCriterion("point_lat <=", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatLike(String value) {
            addCriterion("point_lat like", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatNotLike(String value) {
            addCriterion("point_lat not like", value, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatIn(List<String> values) {
            addCriterion("point_lat in", values, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatNotIn(List<String> values) {
            addCriterion("point_lat not in", values, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatBetween(String value1, String value2) {
            addCriterion("point_lat between", value1, value2, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLatNotBetween(String value1, String value2) {
            addCriterion("point_lat not between", value1, value2, "pointLat");
            return (Criteria) this;
        }

        public Criteria andPointLngIsNull() {
            addCriterion("point_lng is null");
            return (Criteria) this;
        }

        public Criteria andPointLngIsNotNull() {
            addCriterion("point_lng is not null");
            return (Criteria) this;
        }

        public Criteria andPointLngEqualTo(String value) {
            addCriterion("point_lng =", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngNotEqualTo(String value) {
            addCriterion("point_lng <>", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngGreaterThan(String value) {
            addCriterion("point_lng >", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngGreaterThanOrEqualTo(String value) {
            addCriterion("point_lng >=", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngLessThan(String value) {
            addCriterion("point_lng <", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngLessThanOrEqualTo(String value) {
            addCriterion("point_lng <=", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngLike(String value) {
            addCriterion("point_lng like", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngNotLike(String value) {
            addCriterion("point_lng not like", value, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngIn(List<String> values) {
            addCriterion("point_lng in", values, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngNotIn(List<String> values) {
            addCriterion("point_lng not in", values, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngBetween(String value1, String value2) {
            addCriterion("point_lng between", value1, value2, "pointLng");
            return (Criteria) this;
        }

        public Criteria andPointLngNotBetween(String value1, String value2) {
            addCriterion("point_lng not between", value1, value2, "pointLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLatIsNull() {
            addCriterion("gaode_lat is null");
            return (Criteria) this;
        }

        public Criteria andGaodeLatIsNotNull() {
            addCriterion("gaode_lat is not null");
            return (Criteria) this;
        }

        public Criteria andGaodeLatEqualTo(String value) {
            addCriterion("gaode_lat =", value, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLatNotEqualTo(String value) {
            addCriterion("gaode_lat <>", value, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLatGreaterThan(String value) {
            addCriterion("gaode_lat >", value, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLatGreaterThanOrEqualTo(String value) {
            addCriterion("gaode_lat >=", value, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLatLessThan(String value) {
            addCriterion("gaode_lat <", value, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLatLessThanOrEqualTo(String value) {
            addCriterion("gaode_lat <=", value, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLatLike(String value) {
            addCriterion("gaode_lat like", value, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLatNotLike(String value) {
            addCriterion("gaode_lat not like", value, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLatIn(List<String> values) {
            addCriterion("gaode_lat in", values, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLatNotIn(List<String> values) {
            addCriterion("gaode_lat not in", values, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLatBetween(String value1, String value2) {
            addCriterion("gaode_lat between", value1, value2, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLatNotBetween(String value1, String value2) {
            addCriterion("gaode_lat not between", value1, value2, "gaodeLat");
            return (Criteria) this;
        }

        public Criteria andGaodeLngIsNull() {
            addCriterion("gaode_lng is null");
            return (Criteria) this;
        }

        public Criteria andGaodeLngIsNotNull() {
            addCriterion("gaode_lng is not null");
            return (Criteria) this;
        }

        public Criteria andGaodeLngEqualTo(String value) {
            addCriterion("gaode_lng =", value, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLngNotEqualTo(String value) {
            addCriterion("gaode_lng <>", value, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLngGreaterThan(String value) {
            addCriterion("gaode_lng >", value, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLngGreaterThanOrEqualTo(String value) {
            addCriterion("gaode_lng >=", value, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLngLessThan(String value) {
            addCriterion("gaode_lng <", value, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLngLessThanOrEqualTo(String value) {
            addCriterion("gaode_lng <=", value, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLngLike(String value) {
            addCriterion("gaode_lng like", value, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLngNotLike(String value) {
            addCriterion("gaode_lng not like", value, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLngIn(List<String> values) {
            addCriterion("gaode_lng in", values, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLngNotIn(List<String> values) {
            addCriterion("gaode_lng not in", values, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLngBetween(String value1, String value2) {
            addCriterion("gaode_lng between", value1, value2, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andGaodeLngNotBetween(String value1, String value2) {
            addCriterion("gaode_lng not between", value1, value2, "gaodeLng");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(String value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(String value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(String value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(String value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(String value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(String value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLike(String value) {
            addCriterion("distance like", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotLike(String value) {
            addCriterion("distance not like", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<String> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<String> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(String value1, String value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(String value1, String value2) {
            addCriterion("distance not between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andLadderRatioIsNull() {
            addCriterion("ladder_ratio is null");
            return (Criteria) this;
        }

        public Criteria andLadderRatioIsNotNull() {
            addCriterion("ladder_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andLadderRatioEqualTo(String value) {
            addCriterion("ladder_ratio =", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioNotEqualTo(String value) {
            addCriterion("ladder_ratio <>", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioGreaterThan(String value) {
            addCriterion("ladder_ratio >", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioGreaterThanOrEqualTo(String value) {
            addCriterion("ladder_ratio >=", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioLessThan(String value) {
            addCriterion("ladder_ratio <", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioLessThanOrEqualTo(String value) {
            addCriterion("ladder_ratio <=", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioLike(String value) {
            addCriterion("ladder_ratio like", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioNotLike(String value) {
            addCriterion("ladder_ratio not like", value, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioIn(List<String> values) {
            addCriterion("ladder_ratio in", values, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioNotIn(List<String> values) {
            addCriterion("ladder_ratio not in", values, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioBetween(String value1, String value2) {
            addCriterion("ladder_ratio between", value1, value2, "ladderRatio");
            return (Criteria) this;
        }

        public Criteria andLadderRatioNotBetween(String value1, String value2) {
            addCriterion("ladder_ratio not between", value1, value2, "ladderRatio");
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