package com.tt.entity;

import java.util.ArrayList;
import java.util.List;

public class KeLayoutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KeLayoutExample() {
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

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(String value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(String value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(String value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(String value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(String value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(String value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLike(String value) {
            addCriterion("gid like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotLike(String value) {
            addCriterion("gid not like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<String> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<String> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(String value1, String value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(String value1, String value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andFidIsNull() {
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(String value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(String value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(String value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(String value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(String value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(String value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLike(String value) {
            addCriterion("fid like", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotLike(String value) {
            addCriterion("fid not like", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<String> values) {
            addCriterion("fid in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<String> values) {
            addCriterion("fid not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(String value1, String value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(String value1, String value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeIsNull() {
            addCriterion("huxing_type is null");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeIsNotNull() {
            addCriterion("huxing_type is not null");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeEqualTo(String value) {
            addCriterion("huxing_type =", value, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeNotEqualTo(String value) {
            addCriterion("huxing_type <>", value, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeGreaterThan(String value) {
            addCriterion("huxing_type >", value, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("huxing_type >=", value, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeLessThan(String value) {
            addCriterion("huxing_type <", value, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeLessThanOrEqualTo(String value) {
            addCriterion("huxing_type <=", value, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeLike(String value) {
            addCriterion("huxing_type like", value, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeNotLike(String value) {
            addCriterion("huxing_type not like", value, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeIn(List<String> values) {
            addCriterion("huxing_type in", values, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeNotIn(List<String> values) {
            addCriterion("huxing_type not in", values, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeBetween(String value1, String value2) {
            addCriterion("huxing_type between", value1, value2, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingTypeNotBetween(String value1, String value2) {
            addCriterion("huxing_type not between", value1, value2, "huxingType");
            return (Criteria) this;
        }

        public Criteria andHuxingNameIsNull() {
            addCriterion("huxing_name is null");
            return (Criteria) this;
        }

        public Criteria andHuxingNameIsNotNull() {
            addCriterion("huxing_name is not null");
            return (Criteria) this;
        }

        public Criteria andHuxingNameEqualTo(String value) {
            addCriterion("huxing_name =", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameNotEqualTo(String value) {
            addCriterion("huxing_name <>", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameGreaterThan(String value) {
            addCriterion("huxing_name >", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameGreaterThanOrEqualTo(String value) {
            addCriterion("huxing_name >=", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameLessThan(String value) {
            addCriterion("huxing_name <", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameLessThanOrEqualTo(String value) {
            addCriterion("huxing_name <=", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameLike(String value) {
            addCriterion("huxing_name like", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameNotLike(String value) {
            addCriterion("huxing_name not like", value, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameIn(List<String> values) {
            addCriterion("huxing_name in", values, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameNotIn(List<String> values) {
            addCriterion("huxing_name not in", values, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameBetween(String value1, String value2) {
            addCriterion("huxing_name between", value1, value2, "huxingName");
            return (Criteria) this;
        }

        public Criteria andHuxingNameNotBetween(String value1, String value2) {
            addCriterion("huxing_name not between", value1, value2, "huxingName");
            return (Criteria) this;
        }

        public Criteria andFrameImageIsNull() {
            addCriterion("frame_image is null");
            return (Criteria) this;
        }

        public Criteria andFrameImageIsNotNull() {
            addCriterion("frame_image is not null");
            return (Criteria) this;
        }

        public Criteria andFrameImageEqualTo(String value) {
            addCriterion("frame_image =", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageNotEqualTo(String value) {
            addCriterion("frame_image <>", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageGreaterThan(String value) {
            addCriterion("frame_image >", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageGreaterThanOrEqualTo(String value) {
            addCriterion("frame_image >=", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageLessThan(String value) {
            addCriterion("frame_image <", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageLessThanOrEqualTo(String value) {
            addCriterion("frame_image <=", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageLike(String value) {
            addCriterion("frame_image like", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageNotLike(String value) {
            addCriterion("frame_image not like", value, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageIn(List<String> values) {
            addCriterion("frame_image in", values, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageNotIn(List<String> values) {
            addCriterion("frame_image not in", values, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageBetween(String value1, String value2) {
            addCriterion("frame_image between", value1, value2, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameImageNotBetween(String value1, String value2) {
            addCriterion("frame_image not between", value1, value2, "frameImage");
            return (Criteria) this;
        }

        public Criteria andFrameUrlIsNull() {
            addCriterion("frame_url is null");
            return (Criteria) this;
        }

        public Criteria andFrameUrlIsNotNull() {
            addCriterion("frame_url is not null");
            return (Criteria) this;
        }

        public Criteria andFrameUrlEqualTo(String value) {
            addCriterion("frame_url =", value, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andFrameUrlNotEqualTo(String value) {
            addCriterion("frame_url <>", value, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andFrameUrlGreaterThan(String value) {
            addCriterion("frame_url >", value, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andFrameUrlGreaterThanOrEqualTo(String value) {
            addCriterion("frame_url >=", value, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andFrameUrlLessThan(String value) {
            addCriterion("frame_url <", value, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andFrameUrlLessThanOrEqualTo(String value) {
            addCriterion("frame_url <=", value, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andFrameUrlLike(String value) {
            addCriterion("frame_url like", value, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andFrameUrlNotLike(String value) {
            addCriterion("frame_url not like", value, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andFrameUrlIn(List<String> values) {
            addCriterion("frame_url in", values, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andFrameUrlNotIn(List<String> values) {
            addCriterion("frame_url not in", values, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andFrameUrlBetween(String value1, String value2) {
            addCriterion("frame_url between", value1, value2, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andFrameUrlNotBetween(String value1, String value2) {
            addCriterion("frame_url not between", value1, value2, "frameUrl");
            return (Criteria) this;
        }

        public Criteria andBedroomNumIsNull() {
            addCriterion("bedroom_num is null");
            return (Criteria) this;
        }

        public Criteria andBedroomNumIsNotNull() {
            addCriterion("bedroom_num is not null");
            return (Criteria) this;
        }

        public Criteria andBedroomNumEqualTo(String value) {
            addCriterion("bedroom_num =", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumNotEqualTo(String value) {
            addCriterion("bedroom_num <>", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumGreaterThan(String value) {
            addCriterion("bedroom_num >", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumGreaterThanOrEqualTo(String value) {
            addCriterion("bedroom_num >=", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumLessThan(String value) {
            addCriterion("bedroom_num <", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumLessThanOrEqualTo(String value) {
            addCriterion("bedroom_num <=", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumLike(String value) {
            addCriterion("bedroom_num like", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumNotLike(String value) {
            addCriterion("bedroom_num not like", value, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumIn(List<String> values) {
            addCriterion("bedroom_num in", values, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumNotIn(List<String> values) {
            addCriterion("bedroom_num not in", values, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumBetween(String value1, String value2) {
            addCriterion("bedroom_num between", value1, value2, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andBedroomNumNotBetween(String value1, String value2) {
            addCriterion("bedroom_num not between", value1, value2, "bedroomNum");
            return (Criteria) this;
        }

        public Criteria andHallNumIsNull() {
            addCriterion("hall_num is null");
            return (Criteria) this;
        }

        public Criteria andHallNumIsNotNull() {
            addCriterion("hall_num is not null");
            return (Criteria) this;
        }

        public Criteria andHallNumEqualTo(String value) {
            addCriterion("hall_num =", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumNotEqualTo(String value) {
            addCriterion("hall_num <>", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumGreaterThan(String value) {
            addCriterion("hall_num >", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumGreaterThanOrEqualTo(String value) {
            addCriterion("hall_num >=", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumLessThan(String value) {
            addCriterion("hall_num <", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumLessThanOrEqualTo(String value) {
            addCriterion("hall_num <=", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumLike(String value) {
            addCriterion("hall_num like", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumNotLike(String value) {
            addCriterion("hall_num not like", value, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumIn(List<String> values) {
            addCriterion("hall_num in", values, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumNotIn(List<String> values) {
            addCriterion("hall_num not in", values, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumBetween(String value1, String value2) {
            addCriterion("hall_num between", value1, value2, "hallNum");
            return (Criteria) this;
        }

        public Criteria andHallNumNotBetween(String value1, String value2) {
            addCriterion("hall_num not between", value1, value2, "hallNum");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaIsNull() {
            addCriterion("current_area is null");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaIsNotNull() {
            addCriterion("current_area is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaEqualTo(String value) {
            addCriterion("current_area =", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaNotEqualTo(String value) {
            addCriterion("current_area <>", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaGreaterThan(String value) {
            addCriterion("current_area >", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaGreaterThanOrEqualTo(String value) {
            addCriterion("current_area >=", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaLessThan(String value) {
            addCriterion("current_area <", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaLessThanOrEqualTo(String value) {
            addCriterion("current_area <=", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaLike(String value) {
            addCriterion("current_area like", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaNotLike(String value) {
            addCriterion("current_area not like", value, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaIn(List<String> values) {
            addCriterion("current_area in", values, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaNotIn(List<String> values) {
            addCriterion("current_area not in", values, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaBetween(String value1, String value2) {
            addCriterion("current_area between", value1, value2, "currentArea");
            return (Criteria) this;
        }

        public Criteria andCurrentAreaNotBetween(String value1, String value2) {
            addCriterion("current_area not between", value1, value2, "currentArea");
            return (Criteria) this;
        }

        public Criteria andBuildingDistIsNull() {
            addCriterion("building_dist is null");
            return (Criteria) this;
        }

        public Criteria andBuildingDistIsNotNull() {
            addCriterion("building_dist is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingDistEqualTo(String value) {
            addCriterion("building_dist =", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistNotEqualTo(String value) {
            addCriterion("building_dist <>", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistGreaterThan(String value) {
            addCriterion("building_dist >", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistGreaterThanOrEqualTo(String value) {
            addCriterion("building_dist >=", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistLessThan(String value) {
            addCriterion("building_dist <", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistLessThanOrEqualTo(String value) {
            addCriterion("building_dist <=", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistLike(String value) {
            addCriterion("building_dist like", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistNotLike(String value) {
            addCriterion("building_dist not like", value, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistIn(List<String> values) {
            addCriterion("building_dist in", values, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistNotIn(List<String> values) {
            addCriterion("building_dist not in", values, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistBetween(String value1, String value2) {
            addCriterion("building_dist between", value1, value2, "buildingDist");
            return (Criteria) this;
        }

        public Criteria andBuildingDistNotBetween(String value1, String value2) {
            addCriterion("building_dist not between", value1, value2, "buildingDist");
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

        public Criteria andFrameOrientationIsNull() {
            addCriterion("frame_orientation is null");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationIsNotNull() {
            addCriterion("frame_orientation is not null");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationEqualTo(String value) {
            addCriterion("frame_orientation =", value, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationNotEqualTo(String value) {
            addCriterion("frame_orientation <>", value, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationGreaterThan(String value) {
            addCriterion("frame_orientation >", value, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationGreaterThanOrEqualTo(String value) {
            addCriterion("frame_orientation >=", value, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationLessThan(String value) {
            addCriterion("frame_orientation <", value, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationLessThanOrEqualTo(String value) {
            addCriterion("frame_orientation <=", value, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationLike(String value) {
            addCriterion("frame_orientation like", value, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationNotLike(String value) {
            addCriterion("frame_orientation not like", value, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationIn(List<String> values) {
            addCriterion("frame_orientation in", values, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationNotIn(List<String> values) {
            addCriterion("frame_orientation not in", values, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationBetween(String value1, String value2) {
            addCriterion("frame_orientation between", value1, value2, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andFrameOrientationNotBetween(String value1, String value2) {
            addCriterion("frame_orientation not between", value1, value2, "frameOrientation");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNull() {
            addCriterion("is_hot is null");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNotNull() {
            addCriterion("is_hot is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotEqualTo(String value) {
            addCriterion("is_hot =", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotEqualTo(String value) {
            addCriterion("is_hot <>", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThan(String value) {
            addCriterion("is_hot >", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThanOrEqualTo(String value) {
            addCriterion("is_hot >=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThan(String value) {
            addCriterion("is_hot <", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThanOrEqualTo(String value) {
            addCriterion("is_hot <=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLike(String value) {
            addCriterion("is_hot like", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotLike(String value) {
            addCriterion("is_hot not like", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotIn(List<String> values) {
            addCriterion("is_hot in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotIn(List<String> values) {
            addCriterion("is_hot not in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotBetween(String value1, String value2) {
            addCriterion("is_hot between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotBetween(String value1, String value2) {
            addCriterion("is_hot not between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntIsNull() {
            addCriterion("house_sell_cnt is null");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntIsNotNull() {
            addCriterion("house_sell_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntEqualTo(String value) {
            addCriterion("house_sell_cnt =", value, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntNotEqualTo(String value) {
            addCriterion("house_sell_cnt <>", value, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntGreaterThan(String value) {
            addCriterion("house_sell_cnt >", value, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntGreaterThanOrEqualTo(String value) {
            addCriterion("house_sell_cnt >=", value, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntLessThan(String value) {
            addCriterion("house_sell_cnt <", value, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntLessThanOrEqualTo(String value) {
            addCriterion("house_sell_cnt <=", value, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntLike(String value) {
            addCriterion("house_sell_cnt like", value, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntNotLike(String value) {
            addCriterion("house_sell_cnt not like", value, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntIn(List<String> values) {
            addCriterion("house_sell_cnt in", values, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntNotIn(List<String> values) {
            addCriterion("house_sell_cnt not in", values, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntBetween(String value1, String value2) {
            addCriterion("house_sell_cnt between", value1, value2, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSellCntNotBetween(String value1, String value2) {
            addCriterion("house_sell_cnt not between", value1, value2, "houseSellCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntIsNull() {
            addCriterion("house_sold_cnt is null");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntIsNotNull() {
            addCriterion("house_sold_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntEqualTo(String value) {
            addCriterion("house_sold_cnt =", value, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntNotEqualTo(String value) {
            addCriterion("house_sold_cnt <>", value, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntGreaterThan(String value) {
            addCriterion("house_sold_cnt >", value, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntGreaterThanOrEqualTo(String value) {
            addCriterion("house_sold_cnt >=", value, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntLessThan(String value) {
            addCriterion("house_sold_cnt <", value, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntLessThanOrEqualTo(String value) {
            addCriterion("house_sold_cnt <=", value, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntLike(String value) {
            addCriterion("house_sold_cnt like", value, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntNotLike(String value) {
            addCriterion("house_sold_cnt not like", value, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntIn(List<String> values) {
            addCriterion("house_sold_cnt in", values, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntNotIn(List<String> values) {
            addCriterion("house_sold_cnt not in", values, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntBetween(String value1, String value2) {
            addCriterion("house_sold_cnt between", value1, value2, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseSoldCntNotBetween(String value1, String value2) {
            addCriterion("house_sold_cnt not between", value1, value2, "houseSoldCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntIsNull() {
            addCriterion("house_cnt is null");
            return (Criteria) this;
        }

        public Criteria andHouseCntIsNotNull() {
            addCriterion("house_cnt is not null");
            return (Criteria) this;
        }

        public Criteria andHouseCntEqualTo(String value) {
            addCriterion("house_cnt =", value, "houseCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntNotEqualTo(String value) {
            addCriterion("house_cnt <>", value, "houseCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntGreaterThan(String value) {
            addCriterion("house_cnt >", value, "houseCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntGreaterThanOrEqualTo(String value) {
            addCriterion("house_cnt >=", value, "houseCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntLessThan(String value) {
            addCriterion("house_cnt <", value, "houseCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntLessThanOrEqualTo(String value) {
            addCriterion("house_cnt <=", value, "houseCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntLike(String value) {
            addCriterion("house_cnt like", value, "houseCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntNotLike(String value) {
            addCriterion("house_cnt not like", value, "houseCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntIn(List<String> values) {
            addCriterion("house_cnt in", values, "houseCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntNotIn(List<String> values) {
            addCriterion("house_cnt not in", values, "houseCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntBetween(String value1, String value2) {
            addCriterion("house_cnt between", value1, value2, "houseCnt");
            return (Criteria) this;
        }

        public Criteria andHouseCntNotBetween(String value1, String value2) {
            addCriterion("house_cnt not between", value1, value2, "houseCnt");
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