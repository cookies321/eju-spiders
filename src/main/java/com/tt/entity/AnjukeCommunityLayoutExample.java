package com.tt.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnjukeCommunityLayoutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnjukeCommunityLayoutExample() {
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

        public Criteria andRoomtypeIsNull() {
            addCriterion("roomType is null");
            return (Criteria) this;
        }

        public Criteria andRoomtypeIsNotNull() {
            addCriterion("roomType is not null");
            return (Criteria) this;
        }

        public Criteria andRoomtypeEqualTo(String value) {
            addCriterion("roomType =", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotEqualTo(String value) {
            addCriterion("roomType <>", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeGreaterThan(String value) {
            addCriterion("roomType >", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeGreaterThanOrEqualTo(String value) {
            addCriterion("roomType >=", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeLessThan(String value) {
            addCriterion("roomType <", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeLessThanOrEqualTo(String value) {
            addCriterion("roomType <=", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeLike(String value) {
            addCriterion("roomType like", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotLike(String value) {
            addCriterion("roomType not like", value, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeIn(List<String> values) {
            addCriterion("roomType in", values, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotIn(List<String> values) {
            addCriterion("roomType not in", values, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeBetween(String value1, String value2) {
            addCriterion("roomType between", value1, value2, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomtypeNotBetween(String value1, String value2) {
            addCriterion("roomType not between", value1, value2, "roomtype");
            return (Criteria) this;
        }

        public Criteria andRoomIsNull() {
            addCriterion("room is null");
            return (Criteria) this;
        }

        public Criteria andRoomIsNotNull() {
            addCriterion("room is not null");
            return (Criteria) this;
        }

        public Criteria andRoomEqualTo(String value) {
            addCriterion("room =", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotEqualTo(String value) {
            addCriterion("room <>", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThan(String value) {
            addCriterion("room >", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThanOrEqualTo(String value) {
            addCriterion("room >=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThan(String value) {
            addCriterion("room <", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThanOrEqualTo(String value) {
            addCriterion("room <=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLike(String value) {
            addCriterion("room like", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotLike(String value) {
            addCriterion("room not like", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomIn(List<String> values) {
            addCriterion("room in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotIn(List<String> values) {
            addCriterion("room not in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomBetween(String value1, String value2) {
            addCriterion("room between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotBetween(String value1, String value2) {
            addCriterion("room not between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andPicSrcIsNull() {
            addCriterion("pic_src is null");
            return (Criteria) this;
        }

        public Criteria andPicSrcIsNotNull() {
            addCriterion("pic_src is not null");
            return (Criteria) this;
        }

        public Criteria andPicSrcEqualTo(String value) {
            addCriterion("pic_src =", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotEqualTo(String value) {
            addCriterion("pic_src <>", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcGreaterThan(String value) {
            addCriterion("pic_src >", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcGreaterThanOrEqualTo(String value) {
            addCriterion("pic_src >=", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcLessThan(String value) {
            addCriterion("pic_src <", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcLessThanOrEqualTo(String value) {
            addCriterion("pic_src <=", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcLike(String value) {
            addCriterion("pic_src like", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotLike(String value) {
            addCriterion("pic_src not like", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcIn(List<String> values) {
            addCriterion("pic_src in", values, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotIn(List<String> values) {
            addCriterion("pic_src not in", values, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcBetween(String value1, String value2) {
            addCriterion("pic_src between", value1, value2, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotBetween(String value1, String value2) {
            addCriterion("pic_src not between", value1, value2, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNull() {
            addCriterion("pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNotNull() {
            addCriterion("pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            addCriterion("pic_url =", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            addCriterion("pic_url <>", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            addCriterion("pic_url >", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_url >=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThan(String value) {
            addCriterion("pic_url <", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_url <=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLike(String value) {
            addCriterion("pic_url like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotLike(String value) {
            addCriterion("pic_url not like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlIn(List<String> values) {
            addCriterion("pic_url in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            addCriterion("pic_url not in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            addCriterion("pic_url not between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andTowardsIsNull() {
            addCriterion("towards is null");
            return (Criteria) this;
        }

        public Criteria andTowardsIsNotNull() {
            addCriterion("towards is not null");
            return (Criteria) this;
        }

        public Criteria andTowardsEqualTo(String value) {
            addCriterion("towards =", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsNotEqualTo(String value) {
            addCriterion("towards <>", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsGreaterThan(String value) {
            addCriterion("towards >", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsGreaterThanOrEqualTo(String value) {
            addCriterion("towards >=", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsLessThan(String value) {
            addCriterion("towards <", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsLessThanOrEqualTo(String value) {
            addCriterion("towards <=", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsLike(String value) {
            addCriterion("towards like", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsNotLike(String value) {
            addCriterion("towards not like", value, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsIn(List<String> values) {
            addCriterion("towards in", values, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsNotIn(List<String> values) {
            addCriterion("towards not in", values, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsBetween(String value1, String value2) {
            addCriterion("towards between", value1, value2, "towards");
            return (Criteria) this;
        }

        public Criteria andTowardsNotBetween(String value1, String value2) {
            addCriterion("towards not between", value1, value2, "towards");
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