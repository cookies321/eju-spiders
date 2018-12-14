package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FangXfLoupangBuildingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FangXfLoupangBuildingExample() {
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

        public Criteria andLayoutEqualTo(String value) {
            addCriterion("layout =", value, "layout");
            return (Criteria) this;
        }
        public Criteria andLayoutNotEqualTo(String value) {
            addCriterion("layout <>", value, "layout");
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

        public Criteria andDetailPcIsNull() {
            addCriterion("detail_pc is null");
            return (Criteria) this;
        }

        public Criteria andDetailPcIsNotNull() {
            addCriterion("detail_pc is not null");
            return (Criteria) this;
        }

        public Criteria andDetailPcEqualTo(String value) {
            addCriterion("detail_pc =", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcNotEqualTo(String value) {
            addCriterion("detail_pc <>", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcGreaterThan(String value) {
            addCriterion("detail_pc >", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcGreaterThanOrEqualTo(String value) {
            addCriterion("detail_pc >=", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcLessThan(String value) {
            addCriterion("detail_pc <", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcLessThanOrEqualTo(String value) {
            addCriterion("detail_pc <=", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcLike(String value) {
            addCriterion("detail_pc like", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcNotLike(String value) {
            addCriterion("detail_pc not like", value, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcIn(List<String> values) {
            addCriterion("detail_pc in", values, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcNotIn(List<String> values) {
            addCriterion("detail_pc not in", values, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcBetween(String value1, String value2) {
            addCriterion("detail_pc between", value1, value2, "detailPc");
            return (Criteria) this;
        }

        public Criteria andDetailPcNotBetween(String value1, String value2) {
            addCriterion("detail_pc not between", value1, value2, "detailPc");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(String value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(String value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(String value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(String value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(String value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLike(String value) {
            addCriterion("period like", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotLike(String value) {
            addCriterion("period not like", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<String> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<String> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(String value1, String value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(String value1, String value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNull() {
            addCriterion("open_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIsNotNull() {
            addCriterion("open_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenTimeEqualTo(String value) {
            addCriterion("open_time =", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotEqualTo(String value) {
            addCriterion("open_time <>", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThan(String value) {
            addCriterion("open_time >", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeGreaterThanOrEqualTo(String value) {
            addCriterion("open_time >=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThan(String value) {
            addCriterion("open_time <", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLessThanOrEqualTo(String value) {
            addCriterion("open_time <=", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeLike(String value) {
            addCriterion("open_time like", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotLike(String value) {
            addCriterion("open_time not like", value, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeIn(List<String> values) {
            addCriterion("open_time in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotIn(List<String> values) {
            addCriterion("open_time not in", values, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeBetween(String value1, String value2) {
            addCriterion("open_time between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andOpenTimeNotBetween(String value1, String value2) {
            addCriterion("open_time not between", value1, value2, "openTime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeIsNull() {
            addCriterion("roomtime is null");
            return (Criteria) this;
        }

        public Criteria andRoomtimeIsNotNull() {
            addCriterion("roomtime is not null");
            return (Criteria) this;
        }

        public Criteria andRoomtimeEqualTo(String value) {
            addCriterion("roomtime =", value, "roomtime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeNotEqualTo(String value) {
            addCriterion("roomtime <>", value, "roomtime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeGreaterThan(String value) {
            addCriterion("roomtime >", value, "roomtime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeGreaterThanOrEqualTo(String value) {
            addCriterion("roomtime >=", value, "roomtime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeLessThan(String value) {
            addCriterion("roomtime <", value, "roomtime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeLessThanOrEqualTo(String value) {
            addCriterion("roomtime <=", value, "roomtime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeLike(String value) {
            addCriterion("roomtime like", value, "roomtime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeNotLike(String value) {
            addCriterion("roomtime not like", value, "roomtime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeIn(List<String> values) {
            addCriterion("roomtime in", values, "roomtime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeNotIn(List<String> values) {
            addCriterion("roomtime not in", values, "roomtime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeBetween(String value1, String value2) {
            addCriterion("roomtime between", value1, value2, "roomtime");
            return (Criteria) this;
        }

        public Criteria andRoomtimeNotBetween(String value1, String value2) {
            addCriterion("roomtime not between", value1, value2, "roomtime");
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

        public Criteria andChushouNumIsNull() {
            addCriterion("chushou_num is null");
            return (Criteria) this;
        }

        public Criteria andChushouNumIsNotNull() {
            addCriterion("chushou_num is not null");
            return (Criteria) this;
        }

        public Criteria andChushouNumEqualTo(String value) {
            addCriterion("chushou_num =", value, "chushouNum");
            return (Criteria) this;
        }

        public Criteria andChushouNumNotEqualTo(String value) {
            addCriterion("chushou_num <>", value, "chushouNum");
            return (Criteria) this;
        }

        public Criteria andChushouNumGreaterThan(String value) {
            addCriterion("chushou_num >", value, "chushouNum");
            return (Criteria) this;
        }

        public Criteria andChushouNumGreaterThanOrEqualTo(String value) {
            addCriterion("chushou_num >=", value, "chushouNum");
            return (Criteria) this;
        }

        public Criteria andChushouNumLessThan(String value) {
            addCriterion("chushou_num <", value, "chushouNum");
            return (Criteria) this;
        }

        public Criteria andChushouNumLessThanOrEqualTo(String value) {
            addCriterion("chushou_num <=", value, "chushouNum");
            return (Criteria) this;
        }

        public Criteria andChushouNumLike(String value) {
            addCriterion("chushou_num like", value, "chushouNum");
            return (Criteria) this;
        }

        public Criteria andChushouNumNotLike(String value) {
            addCriterion("chushou_num not like", value, "chushouNum");
            return (Criteria) this;
        }

        public Criteria andChushouNumIn(List<String> values) {
            addCriterion("chushou_num in", values, "chushouNum");
            return (Criteria) this;
        }

        public Criteria andChushouNumNotIn(List<String> values) {
            addCriterion("chushou_num not in", values, "chushouNum");
            return (Criteria) this;
        }

        public Criteria andChushouNumBetween(String value1, String value2) {
            addCriterion("chushou_num between", value1, value2, "chushouNum");
            return (Criteria) this;
        }

        public Criteria andChushouNumNotBetween(String value1, String value2) {
            addCriterion("chushou_num not between", value1, value2, "chushouNum");
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