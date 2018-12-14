define("mapV2/js/msg", function (require, g) {
    return $({})
}), define("mapV2/js/bubble", function (require, g) {
    var A, C, I = require("mapV2/js/msg"), e = {
        1: '<div class=\'#{extraClass} bubble\' data-longitude="#{longitude}" data-latitude="#{latitude}" data-id="#{id}"><p>#{name}</p><p>#{price}万</p><p><span>#{house_count}</span>套</p></div>',
        4: '<div class=\'bubble-4 bubble\' data-disabled="1" data-longitude="#{longitude}" data-latitude="#{latitude}" data-id="#{id}" title="#{name}"><span class=\'bubble-4_tri\'></span><p class=\'bubble-4_tip\' title=\'#{sugName}\'>#{sugName}</p></div>',
        2: '<div class="bubble-2 bubble-5 bubble" data-position_border="#{border}" data-longitude="#{longitude}" data-latitude="#{latitude}" data-id="#{id}"><p class="name" title="#{name}">#{name}</p><p class="num">#{unit_price}万</p><p class="count">#{count}套</p></div>',
        "2_nounit_price": '<div class="bubble-2 bubble-5 bubble" data-position_border="#{border}" data-longitude="#{longitude}" data-latitude="#{latitude}" data-id="#{id}"><p class="name" title="#{name}">#{name}</p><p class="count">#{count}套</p></div>',
        21: '<div class="bubble-2 bubble bubble-21" data-longitude="#{longitude}" data-latitude="#{latitude}" data-id="#{id}"><p class="name" title="#{name}">#{name}</p><p class="count">#{house_count}套</p></div>',
        3: '<p class="bubble-3 bubble" data-longitude="#{longitude}" data-latitude="#{latitude}" data-id="#{id}" data-msg="#{otherResource}" data-station="#{subway_station_id}" data-schoolid="#{school_id}" data-time="#{duration}"  data-distance="#{distance}"><i class="num">&nbsp;#{name}&nbsp;#{resblockDesc}&nbsp;#{otherResource}</i><i class="arrow-up"></i></p>',
        11: '<p class="bubble-3 bubble bubble-11" data-disabled="1"><i class="num">&nbsp;#{name}&nbsp;</i><i class="arrow-up"><i class="arrow"></i></i></p>',
        5: '<div class="bubble-2 bubble-5 bubble" data-position_border="#{border}" data-longitude="#{longitude}" data-latitude="#{latitude}" data-id="#{id}" data-name="#{name}"><p class="name" title="#{name}">#{name}</p><p class="num num_#{unit_price}">#{unit_price}万</p><p><span class="count">#{count}套</span></p></div>',
        "5_nounit_price": '<div class="bubble-2 bubble-5 bubble" data-position_border="#{border}" data-longitude="#{longitude}" data-latitude="#{latitude}" data-id="#{id}" data-name="#{name}"><p class="name" title="#{name}">#{name}</p><p><span class="count">#{count}套</span></p></div>',
        6: '<div class="bubble-2 bubble-5 bubble-6 bubble" data-position_border="#{border}" data-longitude="#{longitude}" data-latitude="#{latitude}" data-id="#{id}"><p class="name" title="#{name}">#{name}</p><p class="count">#{school_count}所小学</p></div>',
        7: '<div class="bubble-2 bubble bubble-7" data-imSchool="1" data-longitude="#{longitude}" data-latitude="#{latitude}" data-id="#{id}"><p class="name" title="#{name}">#{name}</p><p class="count">#{house_count}套</p><p class="num">#{min_price_total}万起</p></div>',
        8: "<div class='bubble-4 bubble bubble-8' data-imSchool=\"1\" data-longitude=\"#{longitude}\" data-latitude=\"#{latitude}\" data-id=\"#{id}\"><span class='bubble-4_tri'></span><p class='bubble-4_tip' title='#{name}'>#{name}</p></div>",
        9: '<div class="bubble-2 bubble bubble-9" data-longitude="#{longitude}" data-latitude="#{latitude}" data-id="#{id}"><p class="name" title="#{name}">#{name}</p><p class="num">#{price}</p><p class="count">#{house_count}套</p></div>',
        10: "<div class='bubble-4 bubble bubble-8 bubble-10' data-disabled=\"1\" data-longitude=\"#{longitude}\" data-latitude=\"#{latitude}\" data-id=\"#{id}\"><span class='bubble-4_tri'></span><p class='bubble-4_tip' title='#{name}'>#{name}</p></div>"
    }, t = {
        4: {
            color: "#333333",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            backgroundColor: "transparent",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif'
        },
        1: {
            color: "#fff",
            backgroundColor: "rgba(0, 162, 130, 0.8)",
            height: "69px",
            lineHeight: "23px",
            width: "69px",
            textAlign: "center",
            borderWidth: "0",
            zIndex: "2",
            whiteSpace: "normal",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif'
        },
        3: {
            color: "#fff",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            backgroundColor: "transparent",
            textAlign: "center",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif',
            transform: "translate(-50%, 0)",
            "-webkit-transform": "translate(-50%, 0)",
            "-ms-transform": "translate(-50%, 0)",
            "-o-transform": "translate(-50%, 0)"
        },
        2: {
            color: "#fff",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            backgroundColor: "transparent",
            textAlign: "center",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif'
        },
        21: {
            color: "#fff",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            backgroundColor: "transparent",
            textAlign: "center",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif'
        },
        5: {
            color: "#fff",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            cursor: "pointer",
            backgroundColor: "transparent",
            textAlign: "center",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif'
        },
        6: {
            color: "#fff",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            backgroundColor: "transparent",
            textAlign: "center",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif'
        },
        7: {
            color: "#fff",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            backgroundColor: "transparent",
            textAlign: "center",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif'
        },
        8: {
            color: "#333333",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            backgroundColor: "transparent",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif'
        },
        9: {
            color: "#fff",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            backgroundColor: "transparent",
            textAlign: "center",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif'
        },
        10: {
            color: "#333333",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            backgroundColor: "transparent",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif'
        },
        11: {
            color: "#394043",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            backgroundColor: "transparent",
            textAlign: "center",
            fontFamily: '"Hiragino Sans GB", "Microsoft Yahei UI", "Microsoft Yahei", "微软雅黑", "Segoe UI", Tahoma, "宋体b8bf53", SimSun, sans-serif'
        }
    }, n = {
        4: function () {
            return new BMap.Size(-28, -28)
        }, 1: function () {
            return new BMap.Size(-48, -48)
        }, 3: function () {
            return new BMap.Size(-1, -26)
        }, 11: function () {
            return new BMap.Size(0, -36)
        }, 2: function () {
            return new BMap.Size(-42, -42)
        }, 21: function () {
            return new BMap.Size(-42, -42)
        }, 5: function () {
            return new BMap.Size(-48, -48)
        }, 6: function () {
            return new BMap.Size(-48, -48)
        }, 7: function () {
            return new BMap.Size(-42, -42)
        }, 8: function () {
            return new BMap.Size(-28, -28)
        }, 9: function () {
            return new BMap.Size(-40, -40)
        }, 10: function () {
            return new BMap.Size(-28, -28)
        }
    }, a = {
        tpl: '<p class="line-msg">#{steamMsg}</p>',
        inlineTpl: '<i class="name-other">&nbsp;&nbsp;#{steamMsg}</i>',
        styles: {
            color: "#fffefe",
            borderWidth: "0",
            padding: "0",
            zIndex: "2",
            backgroundColor: "transparent",
            textAlign: "center"
        },
        offset: function () {
            return new BMap.Size(-54, -15)
        }
    }, i = [], o = [], r = null, l = {
        _polygonLine: null, _render: function (g) {
            A.addOverlay(g)
        }, clear: function (g) {
            for (var A = null; A = i.shift();) l._remove(A);
            g && r && (l._remove(r), r = null), C && clearTimeout(C), I.trigger("clear_resblock_card")
        }, clearAll: function () {
            for (var g = null; g = i.shift();) l._remove(g);
            for (; g = o.shift();) l._remove(g);
            l._remove(r), r = null
        }, _fixNumber: function (g) {
            return g = g && (parseFloat(g) / 1e4).toFixed(1) || "", g = "0.0" === g ? "" : g
        }, _remove: function (g) {
            A.removeOverlay(g)
        }, _create: function (g) {
            var A, C = n[g.bubbleLevel]();
            g.yOffset && (C = new BMap.Size(0, g.yOffset));
            var a = !1;
            return 2 != g.bubbleLevel && 5 != g.bubbleLevel || 0 == parseFloat(g.unit_price) && (a = !0), A = a ? new BMap.Label($.replaceTpl(e[g.bubbleLevel + "_nounit_price"], g), {
                position: new BMap.Point(g.longitude, g.latitude),
                offset: C
            }) : new BMap.Label($.replaceTpl(e[g.bubbleLevel], g), {
                position: new BMap.Point(g.longitude, g.latitude),
                offset: C
            }), g.isCenterBubble || (A.addEventListener("mouseover", function () {
                this.setStyle({zIndex: "4"})
            }), A.addEventListener("mouseout", function () {
                this.setStyle({zIndex: "2"})
            }), navigator.userAgent.search("iPad") > -1 && A.addEventListener("click", function (g) {
                var A;
                try {
                    A = $(this.K).children(".bubble")
                } catch (g) {
                }
                A && A.length && I.trigger("bubble_click", A)
            })), A.setStyle(t[g.bubbleLevel]), g.isCenterBubble ? r = A : "11" == g.bubbleLevel ? o.push(A) : i.push(A), A
        }, add: function (g) {
            for (var A = 0, C = g.length; A < C; A++) g[A].longitude && g[A].latitude && (g[A].unit_price = g[A].unit_price ? (g[A].unit_price / 1e4).toFixed(1) : 0, g[A].price = l._fixNumber(g[A].avg_unit_price) || l._fixNumber(g[A].bs_avg_unit_price), g[A].price = g[A].price && "0.0" != g[A].price ? g[A].price + "万" : "", g[A].id = g[A].id || "", g[A].otherResource = "", g[A].resblockDesc = "", g[A].unit_price && (g[A].resblockDesc = "<b>" + g[A].unit_price + "万</b>&nbsp"), g[A].resblockDesc += g[A].count + "套", g[A].duration && (g[A].resblockDesc += " " + Math.ceil(g[A].duration / 60) + "分钟"), g[A].other_ctrl = $.inArray(g_conf.cityId, ["350200", "430100", "420100", "440300", "500000", "370101"]) > -1 ? 'onclick="return false" style="text-decoration: none;cursor:default"' : "", l._render(l._create(g[A])))
        }, addWhiteBubble: function (g) {
            g.bubbleLevel = "11", l._render(l._create(g))
        }, hasCenterPoint: function () {
            return !!r
        }, getCenter: function () {
            return r
        }, drawLine: function (g, C, I, e) {
            var t = new BMap.Polygon([new BMap.Point(g.lng, g.lat), new BMap.Point(C.lng, C.lat)], {
                strokeColor: "#e4393c",
                strokeWeight: 2,
                strokeOpacity: 1,
                strokeStyle: "solid",
                enableClicking: !1
            }), n = new BMap.Label($.replaceTpl(a.tpl, {steamMsg: I}), {
                position: new BMap.Point(((g.lng + C.lng) / 2).toFixed(6), ((g.lat + C.lat) / 2).toFixed(6)),
                offset: a.offset()
            });
            return n.setStyle(a.styles), function (g) {
                setTimeout(function () {
                    g.setStyle({zIndex: "2"})
                }, 50)
            }(n), A.addOverlay(t), A.addOverlay(n), e.find(".name-other").length || e.find(".name-des").append($.replaceTpl(a.inlineTpl, {steamMsg: I})), {
                label: n,
                line: t
            }
        }, clearLine: function (g) {
            A.removeOverlay(g.label), A.removeOverlay(g.line)
        }, drawPolygon: function (g) {
            var C = [], I = g.split(";"), e = null;
            l._polygonLine && (A.removeOverlay(l._polygonLine), l._polygonLine = null), I.length < 2 || ($.each(I, function (g, A) {
                var I = A.split(",");
                2 === I.length && C.push(new BMap.Point(parseFloat(I[0]), parseFloat(I[1])))
            }), C.length < 2 || (e = new BMap.Polygon(C, {
                strokeColor: "#3072f6",
                strokeWeight: 2,
                strokeOpacity: 1,
                fillColor: "#3072f6",
                fillOpacity: .15,
                strokeStyle: "solid",
                enableClicking: !1
            }), l._polygonLine = e, A.addOverlay(e)))
        }, clearPolygon: function () {
            l._polygonLine && A.removeOverlay(l._polygonLine), l._polygonLine = null
        }, init: function (g) {
            var e = l;
            A = g.map, $(document.body).on("mouseenter", ".bubble", function () {
                var g = $(this).attr("data-position_border");
                if (g ? e.drawPolygon(g) : e.clearPolygon(), $(this).hasClass("bubble-3")) {
                    var A = $(this).data("id"), t = $(this).data("latitude"), n = $(this).data("longitude");
                    C && clearTimeout(C), C = setTimeout(function () {
                        I.trigger("fetch_resblock_card", {ids: A, lat: t, lng: n})
                    }, 500)
                }
            }).on("mouseleave", ".bubble", function () {
                e.clearPolygon(), $(this).hasClass("bubble-3") && (C && clearTimeout(C), I.trigger("clear_resblock_card"))
            })
        }
    };
    return I.on("clearAllBubble", function () {
        l.clear(), C && clearTimeout(C), I.trigger("clear_resblock_card"), I.trigger("clearStationInfo")
    }), {
        clear: l.clear,
        clearAll: l.clearAll,
        add: l.add,
        hasCenter: l.hasCenterPoint,
        getCenter: l.getCenter,
        drawLine: l.drawLine,
        clearLine: l.clearLine,
        drawPolygon: l.drawPolygon,
        clearPolygon: l.clearPolygon,
        init: l.init,
        addWhiteBubble: l.addWhiteBubble
    }
}), define("mapV2/js/circle", function (require, g) {
    function A() {
        if (!d || d.getZoom() < 14) {
            m.trigger("exit_model");
            var g = $('<p class="circle_tips bubble-3 bubble"><i class="num">请放大地图后使用画圈找房</i><i class="arrow-up"><i class="arrow"></i></i></p>');
            return g.appendTo($("#" + g_conf.mapWrapper)), setTimeout(function () {
                g.remove()
            }, 2e3), !1
        }
        return $(".circle_shadow").show(), p.show(), v.hasClass("active") && $(".close_list").trigger("click"), !0
    }

    function C() {
        p.hide(), $(".circle_shadow").hide(), w = e(), d.removeOverlay(u), d.removeOverlay(f), h.hide()
    }

    function I() {
        $(".circle_shadow").hide(), p.hide()
    }

    function e() {
        return {pointArray: []}
    }

    function t(g, A) {
        return d.pixelToPoint({x: g, y: A})
    }

    function n(g) {
        p.on("mousedown", y.start), p.on("mousemove", y.move), p.on("mouseup", y.end), m.on("move_circle", function (g, A) {
            a(), m.trigger("enter_model", {type: "circle"}), w = e();
            for (var C = 0; C < A.pointArray.length; C++) w.pointArray.push(new BMap.Point(A.pointArray[C].lng, A.pointArray[C].lat));
            f.setPath(w.pointArray), A.callback && A.callback()
        }), h.on("click", function () {
            if (!d || d.getZoom() < 14) {
                var g = $('<p class="circle_tips bubble-3 bubble"><i class="num">请放大地图后使用画圈找房</i><i class="arrow-up"><i class="arrow"></i></i></p>');
                return g.appendTo($("#" + g_conf.mapWrapper)), setTimeout(function () {
                    g.remove()
                }, 2e3), !1
            }
            C(), $(".circle_shadow").show(), _.clear(), p.show()
        })
    }

    function a() {
        u = new BMap.Polyline([], {strokeWeight: 5, strokeColor: "#3072f6"}), f = new BMap.Polygon([], {
            strokeWeight: 5,
            fillColor: "#3072f6",
            strokeOpacity: 1,
            strokeColor: "#3072f6",
            fillOpacity: .3
        }), d.addOverlay(u), d.addOverlay(f)
    }

    function i(g) {
        d = g.map, n(g.map)
    }

    function o() {
        var g = f.getBounds(), A = g.getSouthWest(), C = g.getNorthEast();
        return {min_longitude: A.lng, max_longitude: C.lng, min_latitude: A.lat, max_latitude: C.lat}
    }

    function r() {
        var g = d.getBounds(), A = g.getSouthWest(), C = g.getNorthEast();
        return {min_longitude: A.lng, max_longitude: C.lng, min_latitude: A.lat, max_latitude: C.lat}
    }

    function l() {
        var g = o(), A = r(), C = d.getZoom(),
            I = (A.max_longitude - A.min_longitude) / (g.max_longitude - g.min_longitude),
            e = (A.max_latitude - A.min_latitude) / (g.max_latitude - g.min_latitude),
            t = C + Math.floor(Math.min(I, e)) - 1;
        return t = t > C ? t : C, {
            longitude: (g.max_longitude + g.min_longitude) / 2,
            latitude: (g.max_latitude + g.min_latitude) / 2,
            zoom: t
        }
    }

    function s(g) {
        var A = w.pointArray.length, C = [], I = [];
        $.each(w.pointArray, function (g, A) {
            C.push(A.lat), I.push(A.lng)
        });
        for (var e = g.lat, t = g.lng, n = 0, a = 0, i = A - 1; a < A; i = a++) I[a] > t != I[i] > t && e < (C[i] - C[a]) * (t - I[a]) / (I[i] - I[a]) + C[a] && (n = !n);
        return n
    }

    function c() {
        return w
    }

    var d, u, f, m = require("mapV2/js/msg"), p = $("#" + g_conf.circleId), b = !1, h = $("#" + g_conf.redraw),
        v = $("#" + g_conf.houseListId), _ = require("mapV2/js/bubble"), w = e(), y = {
            start: function (g) {
                b = !0, w.pointArray.push(t(g.clientX, g.clientY - 111)), a()
            }, move: function (g) {
                b && (g.preventDefault(), u.show(), f.show(), w.pointArray.push(t(g.clientX, g.clientY - 111)), u.setPath(w.pointArray))
            }, end: function (g) {
                b = !1, f.setPath(w.pointArray);
                var A = l();
                d.getZoom();
                m.trigger("move_Area", A), p.hide(), h.show(), $(".circle_shadow").hide()
            }
        };
    return {init: i, show: A, hide: I, getParam: o, getState: c, isInBound: s, exit: C}
}), define("mapV2/js/ditie", function (require, g) {
    function A(g) {
        g = g.data;
        for (var A = "", C = 0; C < g.length; C++) {
            var I = g[C];
            A += '<li class="ditie_li" data-id="' + I.id + '" data-baiduId="' + I.baiduCode + '" data-name="' + I.name + '">' + I.name + "</li>"
        }
        $(A).appendTo($(".ditieLine_ul").empty())
    }

    function C() {
        y && p.removeOverlay(y), y = null, $(".ditieLine_ul").hide(), k.trigger("destory_ditie")
    }

    function I() {
        return {line: Math.round(leftScrollTop / b), station: Math.round(rightScrollTop / b)}
    }

    function e() {
        S.addClass("active"), _ && _.hide(), k.trigger("showWhiteOverlay"), $(".ditieLine_ul").show()
    }

    function t() {
        _.hide(), S.removeClass("active")
    }

    function n() {
        S.removeClass("active"), "ditie" == g_conf.model && _ && _.show(), T = i(j)
    }

    function a() {
        return {line_id: null, station_id: null, longitude: null, latitude: null, station_name: null}
    }

    function i(g) {
        return {
            line_id: g.line_id,
            station_id: g.station_id,
            longitude: g.longitude,
            latitude: g.latitude,
            station_name: g.station_name
        }
    }

    function o(g) {
        var A = g.line_id, C = g.latitude, I = g.longitude;
        window.g_conf.startDitie = !0;
        var e = {line_id: A, station_id: g.id, longitude: I, latitude: C, station_name: g.text};
        T = e, w = A, p.centerAndZoom(new BMap.Point(I, C), 16), k.trigger("removeWhiteOverlay"), k.trigger("subwayIcoShow")
    }

    function r(g, A) {
        g_conf.curLineMap && (g_conf.curLineMap.clearResults(), g_conf.curLineMap = null), h = !0, g_conf.curLineMap = new BMap.BusLineSearch(p, {
            renderOptions: {map: p},
            onPolylinesSet: function (g) {
                setTimeout(function () {
                    g.setStrokeColor("#3f88fb"), g.setStrokeWeight(2), g.setStrokeOpacity(1), p.removeOverlay(g), p.addOverlay(g)
                }, 600)
            },
            onGetBusListComplete: function (g) {
                if (g) {
                    var C = g.getBusListItem(0);
                    g_conf.curLineMap.getBusLine(C), setTimeout(function () {
                        if (h = !1, A && A.curStationId) k.trigger("click_Area", {
                            latitude: A.lat,
                            longitude: A.lng,
                            id: A.curStationId,
                            name: A.curStationName,
                            zoom: p.getZoom()
                        }); else {
                            var g = I(), C = v[g.line].station, e = C[Math.round(C.length / 2)].latitude,
                                t = C[Math.round(C.length / 2)].longitude;
                            k.trigger("move_Area", {latitude: e, longitude: t, imSpecial: !0})
                        }
                    }, 1e3)
                }
            }
        }), setTimeout(function () {
            g_conf.curLineMap.getBusList("地铁" + g), g_conf.curLineMap.setMarkersSetCallback(function (g) {
                setTimeout(function () {
                    $.each(g, function (g, A) {
                        p.removeOverlay(A)
                    })
                }, 200)
            })
        }, 10)
    }

    function l(g, A, C) {
        var I, e = {renderOptions: {map: p, autoViewport: !1}};
        e.onPolylinesSet = function (A) {
            y && p.removeOverlay(y), x && p.removeOverlay(x);
            var C = A[0].getPolyline();
            C.setStrokeOpacity(1), C.setStrokeColor("#2dc686"), C.setStrokeStyle("solid"), C.setStrokeWeight(4), p.addOverlay(C), y = C, x = new BMap.Label('<div class="route_dot"></div>', {
                position: A[0].getPath()[0] || g,
                offset: new BMap.Size(-7, -3)
            }), x.setStyle({border: "none", "z-index": 3, "background-color": "transparent"}), p.addOverlay(x)
        }, e.onMarkersSet = function (g) {
            p.removeOverlay(g[0].marker), p.removeOverlay(g[1].marker)
        }, e.onSearchComplete = function (g) {
            if (I.getStatus() == BMAP_STATUS_SUCCESS) {
                for (var A = g.getPlan(0), e = A.getRoute(0), t = [], n = 0; n < e.getNumSteps(); n++) {
                    var a = e.getStep(n);
                    t.push(a.getDescription())
                }
                var i = A.getDuration(!1);
                i = Math.ceil(i / 60) + "分钟", $(".num").each(function () {
                    var g = $(this);
                    g.text(g.text().split("距离")[0])
                }), C && C.find(".num").text(C.find(".num").text() + "距离" + T.station_name + A.getDistance())
            }
        }, I = new BMap.WalkingRoute(p, e), I.search(g, A)
    }

    function s(g) {
        $(".actCancelDitie").on("tap", L.cancel), $(".actOkDitie").on("tap", L.ok), $(".actShowTips").on("tap", L.showTips), $(document.body).on("click", ".ditie_li", L.showSingleDitieLine), $(document.body).on("mouseenter", ".station", L.showStationInfo), $(document.body).on("mouseleave", ".station", L.clearStationInfo), $(document.body).on("click", ".station", L.showStationDetail), k.on("show_schedule", function (g, A) {
            l(new BMap.Point(A.longitude, A.latitude), new BMap.Point(T.longitude, T.latitude), A.el)
        }), k.on("showDetailBySug", function (g, A) {
            o(A)
        }), k.on("clear_search_route", function (g) {
            y && p.removeOverlay(y), x && p.removeOverlay(x), y = null
        })
    }

    function c(g) {
        $('<div class="ditieLine_frame"><div class="ditieLine"><ul class="ditieLine_ul"></ul></div></div>').appendTo($(document.body)), s(g.map), p = g.map, setTimeout(function () {
            k.trigger("renderDitie")
        })
    }

    function d() {
        return T
    }

    function u(g, A) {
        T.station_id = g, T.station_name = A;
        for (var C = T.line_id, I = 0; I < v.length; I++) if (v[I].id == C) {
            for (var e = v[I].station, t = 0; t < e.length; t++) if (e[t].id == g) {
                T.station_index = t;
                break
            }
            break
        }
        j = i(T)
    }

    function f() {
        T = a(), C(), g_conf.curLineMap && g_conf.curLineMap.clearResults(), M = !1, window.g_conf.startDitie = !1, window.g_conf.model = "normal", $(".ditieLine_ul").hide(), $(".ditie_li").removeClass("active"), $(".toSubway").removeClass("active").find("span").text("地铁找房"), k.trigger("removeWhiteOverlay"), k.trigger("ditiePolyline"), k.trigger("removeDitieLabel"), k.trigger("clear_search_route"), k.trigger("clearStationInfo")
    }

    function m() {
        return M
    }

    var p, b, h, v, _, w, y, x, k = require("mapV2/js/msg"), S = $("#" + g_conf.ditieId),
        M = ($("#" + g_conf.mapWrapper), !1), T = a(), j = i(T), L = {
            showStationInfo: function () {
                var g = $(this), A = g.data("id"), C = g.data("lid"), I = g.data("latitude"), e = g.data("longitude");
                k.trigger("showStationInfo", {id: A});
                var t = {line_id: C, station_id: A, longitude: e, latitude: I, station_name: g.data("name")};
                T = t
            }, clearStationInfo: function () {
                k.trigger("clearStationInfo")
            }, showSingleDitieLine: function () {
                k.trigger("clear_search_route"), $("#" + g_conf.houseListId).hasClass("active") && $(".close_list").trigger("click");
                var g = $(this), A = g.data("id"), C = (g.data("baiduId"), g.data("name"));
                k.trigger("showSingleDitieLine", {
                    id: A,
                    name: C
                }), $(this).siblings("li").removeClass("active"), $(this).addClass("active"), window.g_conf.startDitie = !1
            }, showStationDetail: function (g) {
                g.stopPropagation(), g.preventDefault();
                var A = $(this), C = A.data("lid"), I = A.data("latitude"), e = A.data("longitude");
                return window.g_conf.startDitie = !0, w = C, p.centerAndZoom(new BMap.Point(e, I), 16), k.trigger("removeWhiteOverlay"), k.trigger("subwayIcoShow"), !1
            }, cancel: function () {
                n(), M || k.trigger("exit_model")
            }, ok: function () {
                M = !0, j = i(T);
                var g = I();
                r(v[g.line].name, {
                    curLineId: T.line_id,
                    curStationId: T.station_id,
                    curStationName: T.station_name,
                    lat: T.latitude,
                    lng: T.longitude
                }), $(".actShowTips").html('<i class="icon_sp icon_subway"></i>' + T.line_name + '<i class="icon_sp icon_arrow_down"></i>'), n()
            }, showTips: function () {
                e()
            }
        };
    return {init: c, show: e, hide: n, reset: t, getParam: d, setStation: u, isStart: m, exit: f, renderDitie: A}
}), define("mapV2/js/ctl", function (require, g) {
    var A, C = require("mapV2/js/msg"), I = require("mapV2/js/circle"), e = require("mapV2/js/ditie"),
        t = ($("#" + g_conf.mapWrapper), $("#" + g_conf.ctl));
    $(".toSubway").on("click", function () {
        ($("#" + g_conf.houseListId).hasClass("active") && $(".close_list").trigger("click"), "circle" == window.g_conf.model && (I.exit(), $(".toCircle").removeClass("active").find("span").text("画圈找房")), "ditie" != window.g_conf.model) ? (C.trigger("removeHint"), A.setActive("ditie").hide(), e.show(), $(this).addClass("active").find("span").text("退出地铁找房"), C.trigger("remove_resblock_label")) : (A.exit(), $(this).removeClass("active").find("span").text("地铁找房"))
    }), $(".toCircle").on("click", function () {
        if ("ditie" == window.g_conf.model && e.exit(), "circle" != window.g_conf.model) {
            C.trigger("removeHint"), A.setActive("circle").hide();
            I.show() && $(this).addClass("active").find("span").text("退出画圈找房") && C.trigger("remove_resblock_label")
        } else A.exit(), $(this).removeClass("active").find("span").text("画圈找房")
    });
    var n;
    return function () {
        n = $('<a class="exit" style="display:none;">退出</a>'), n.on("tap", function (g) {
            A.exit()
        }), n.appendTo(document.body), C.on("showExit", function () {
            n.show()
        }), C.on("exit_model", function () {
            A.exit()
        }), C.on("enter_model", function (g, C) {
            var I = C.type;
            A.setActive(I).hide()
        })
    }(), A = {
        hide: function () {
            return t.hide(), this
        }, show: function () {
            return this
        }, setActive: function (g) {
            return t.hide(), window.g_conf.model = g, C.trigger("clearAllBubble"), C.trigger("showExit"), this
        }, reset: function () {
            t.find("a").removeClass("active"), window.g_conf.model = "normal"
        }, exit: function (g) {
            var A = {ditie: e, circle: I};
            for (var t in A) A[t].exit();
            window.g_conf.model = "normal", void 0 == g && C.trigger("update_Area"), n.hide()
        }
    }, A
}), define("mapV2/js/mapView", function (require, g) {
    function A(g, A, I) {
        v.push({func: g, selfConf: A, context: I}), 1 === v.length && C()
    }

    function C() {
        for (var g = null, A = 0, C = v.length; A < C; A++) g = v[A], g.context ? g.func.call(context, {
            map: m,
            $map: p
        }, g.selfConf) : g.func({map: m, $map: p}, g.selfConf);
        v.length = 0
    }

    function I() {
        function g() {
            f.trigger("firstInit"), setTimeout(function () {
                m.removeEventListener("tilesloaded", g)
            }, 0)
        }

        f.on("update", function (g, A) {
            setTimeout(function () {
                f.trigger("update_" + g_conf.curChannel, A)
            }, 150)
        }), m.addEventListener("tilesloaded", g), m.addEventListener("zoomend", function () {
            clearTimeout(s), s = setTimeout(function () {
                _ && f.trigger("update", {channel: "zoom"}), _ = !0, e() < 16 && $(".station_icon").hide()
            }, 50)
        }), m.addEventListener("movestart", function (g) {
            u = g.target.getCenter()
        }), m.addEventListener("moveend", function (g) {
            if (window.noReset) return void setTimeout(function () {
                window.noReset = 0
            }, 250);
            u && Math.abs(g.target.getCenter().lng - u.lng) < .005 && Math.abs(g.target.getCenter().lat - u.lat) < .005 && $(".houseList").hasClass("active") || (clearTimeout(c), c = setTimeout(function () {
                f.trigger("update", {channel: "drag"})
            }, 50))
        }), f.on("resetMap", function (g) {
            a()
        }), f.on("bubble_click", function (g, A) {
            var C = $(A);
            C.attr("data-disabled") || (C.hasClass("bubble-3") ? window.g_conf.currentResblockLabel = {
                lng: C.attr("data-longitude"),
                lat: C.attr("data-latitude")
            } : $(".bubble").hide(), f.trigger("click_" + g_conf.curChannel, {
                longitude: C.attr("data-longitude"),
                latitude: C.attr("data-latitude"),
                id: C.attr("data-id"),
                name: C.attr("data-name"),
                isSchool: "1" === C.attr("data-imSchool"),
                distance: C.attr("data-distance"),
                duration: C.attr("data-time"),
                renderHouse: C.hasClass("bubble-3"),
                el: C
            }), d && d.length && (d.removeClass("clicked"), "ditie" == g_conf.model && d.removeClass("ditie_clicked"), d.parent().removeClass("label-clicked")), d = C, d.addClass("clicked"), d.parent().addClass("label-clicked"), "ditie" == g_conf.model && d.addClass("ditie_clicked"))
        }), f.on("bubble_click_style", function (g, A) {
            setTimeout(function () {
                var g = $(A);
                g.attr("data-disabled") || (g.hasClass("bubble-3") || $(".bubble").hide(), d && d.length && (d.removeClass("clicked"), "ditie" == g_conf.model && d.removeClass("ditie_clicked"), d.parent().removeClass("label-clicked")), d = g, d.addClass("clicked"), d.parent().addClass("label-clicked"), "ditie" == g_conf.model && d.addClass("ditie_clicked"))
            }, 1e3)
        }), $(document.body).on("click", ".bubble", function () {
            f.trigger("bubble_click", $(this))
        }), $(document.body).on("click", ".enlarge", function () {
            m.zoomIn()
        }), $(document.body).on("click", ".narrow", function () {
            m.zoomOut()
        })
    }

    function e() {
        return m.getZoom()
    }

    function t() {
        return m.getCenter()
    }

    function n(g, A, C) {
        m.getZoom() == C ? m.panTo(new BMap.Point(g, A)) : m.centerAndZoom(new BMap.Point(g, A), C)
    }

    function a() {
        m.centerAndZoom(g_conf.cityName, 12)
    }

    function i() {
        var g = m.getBounds(), A = g.getSouthWest(), C = g.getNorthEast();
        return {min_longitude: A.lng, max_longitude: C.lng, min_latitude: A.lat, max_latitude: C.lat}
    }

    function o(g) {
        h = g
    }

    function r() {
        var g = $("#control");
        $('<div class="control_content"><a class="enlarge"><i class="map_icon icon_jia"></i></a><a class="narrow"><i class="map_icon icon_jian"></i></a></div>').appendTo(g)
    }

    function l(g) {
        var A = "global_callback" + +new Date;
        b[A] = function () {
            setTimeout(function () {
                m = new BMap.Map(g_conf.mapWrapper, {
                    enableMapClick: !1,
                    minZoom: 11
                }), m.enableScrollWheelZoom(), m.enableContinuousZoom(), m.disableInertialDragging(), m.centerAndZoom(g_conf.cityName, 12), f.one("firstInit", function () {
                    C(), h || f.trigger("update_Area"), m.addControl(new BMap.ScaleControl({
                        anchor: BMAP_ANCHOR_BOTTOM_RIGHT,
                        offset: new BMap.Size(20, 20)
                    })), r()
                }), I()
            }, 20)
        }, b[A]()
    }

    var s, c, d, u, f = require("mapV2/js/msg"),
        m = (require("mapV2/js/ctl"), require("mapV2/js/ditie"), require("mapV2/js/circle"), null), p = null,
        b = window, h = !1, v = [], _ = !1;
    return f.on("dragStatus", function (g, A) {
        g_conf.ignoreSearch = A
    }), v.push({
        func: function () {
            p = $("#" + g_conf.mapWrapper)
        }, selfConf: null, context: null
    }), {
        init: l, addCb: A, centerAndZoom: n, resetMap: a, getZoom: e, getCenter: t, getMap: function () {
            return m
        }, getBounds: i, setExecuted: o
    }
}), define("mapV2/js/util/md5", function () {
    return function () {
        "use strict";

        function g(g, A) {
            var C = (65535 & g) + (65535 & A);
            return (g >> 16) + (A >> 16) + (C >> 16) << 16 | 65535 & C
        }

        function A(g, A) {
            return g << A | g >>> 32 - A
        }

        function C(C, I, e, t, n, a) {
            return g(A(g(g(I, C), g(t, a)), n), e)
        }

        function I(g, A, I, e, t, n, a) {
            return C(A & I | ~A & e, g, A, t, n, a)
        }

        function e(g, A, I, e, t, n, a) {
            return C(A & e | I & ~e, g, A, t, n, a)
        }

        function t(g, A, I, e, t, n, a) {
            return C(A ^ I ^ e, g, A, t, n, a)
        }

        function n(g, A, I, e, t, n, a) {
            return C(I ^ (A | ~e), g, A, t, n, a)
        }

        function a(A, C) {
            A[C >> 5] |= 128 << C % 32, A[14 + (C + 64 >>> 9 << 4)] = C;
            var a, i, o, r, l, s = 1732584193, c = -271733879, d = -1732584194, u = 271733878;
            for (a = 0; a < A.length; a += 16) i = s, o = c, r = d, l = u, s = I(s, c, d, u, A[a], 7, -680876936), u = I(u, s, c, d, A[a + 1], 12, -389564586), d = I(d, u, s, c, A[a + 2], 17, 606105819), c = I(c, d, u, s, A[a + 3], 22, -1044525330), s = I(s, c, d, u, A[a + 4], 7, -176418897), u = I(u, s, c, d, A[a + 5], 12, 1200080426), d = I(d, u, s, c, A[a + 6], 17, -1473231341), c = I(c, d, u, s, A[a + 7], 22, -45705983), s = I(s, c, d, u, A[a + 8], 7, 1770035416), u = I(u, s, c, d, A[a + 9], 12, -1958414417), d = I(d, u, s, c, A[a + 10], 17, -42063), c = I(c, d, u, s, A[a + 11], 22, -1990404162), s = I(s, c, d, u, A[a + 12], 7, 1804603682), u = I(u, s, c, d, A[a + 13], 12, -40341101), d = I(d, u, s, c, A[a + 14], 17, -1502002290), c = I(c, d, u, s, A[a + 15], 22, 1236535329), s = e(s, c, d, u, A[a + 1], 5, -165796510), u = e(u, s, c, d, A[a + 6], 9, -1069501632), d = e(d, u, s, c, A[a + 11], 14, 643717713), c = e(c, d, u, s, A[a], 20, -373897302), s = e(s, c, d, u, A[a + 5], 5, -701558691), u = e(u, s, c, d, A[a + 10], 9, 38016083), d = e(d, u, s, c, A[a + 15], 14, -660478335), c = e(c, d, u, s, A[a + 4], 20, -405537848), s = e(s, c, d, u, A[a + 9], 5, 568446438), u = e(u, s, c, d, A[a + 14], 9, -1019803690), d = e(d, u, s, c, A[a + 3], 14, -187363961), c = e(c, d, u, s, A[a + 8], 20, 1163531501), s = e(s, c, d, u, A[a + 13], 5, -1444681467), u = e(u, s, c, d, A[a + 2], 9, -51403784), d = e(d, u, s, c, A[a + 7], 14, 1735328473), c = e(c, d, u, s, A[a + 12], 20, -1926607734), s = t(s, c, d, u, A[a + 5], 4, -378558), u = t(u, s, c, d, A[a + 8], 11, -2022574463), d = t(d, u, s, c, A[a + 11], 16, 1839030562), c = t(c, d, u, s, A[a + 14], 23, -35309556), s = t(s, c, d, u, A[a + 1], 4, -1530992060), u = t(u, s, c, d, A[a + 4], 11, 1272893353), d = t(d, u, s, c, A[a + 7], 16, -155497632), c = t(c, d, u, s, A[a + 10], 23, -1094730640), s = t(s, c, d, u, A[a + 13], 4, 681279174), u = t(u, s, c, d, A[a], 11, -358537222), d = t(d, u, s, c, A[a + 3], 16, -722521979), c = t(c, d, u, s, A[a + 6], 23, 76029189), s = t(s, c, d, u, A[a + 9], 4, -640364487), u = t(u, s, c, d, A[a + 12], 11, -421815835), d = t(d, u, s, c, A[a + 15], 16, 530742520), c = t(c, d, u, s, A[a + 2], 23, -995338651), s = n(s, c, d, u, A[a], 6, -198630844), u = n(u, s, c, d, A[a + 7], 10, 1126891415), d = n(d, u, s, c, A[a + 14], 15, -1416354905), c = n(c, d, u, s, A[a + 5], 21, -57434055), s = n(s, c, d, u, A[a + 12], 6, 1700485571), u = n(u, s, c, d, A[a + 3], 10, -1894986606), d = n(d, u, s, c, A[a + 10], 15, -1051523), c = n(c, d, u, s, A[a + 1], 21, -2054922799), s = n(s, c, d, u, A[a + 8], 6, 1873313359), u = n(u, s, c, d, A[a + 15], 10, -30611744), d = n(d, u, s, c, A[a + 6], 15, -1560198380), c = n(c, d, u, s, A[a + 13], 21, 1309151649), s = n(s, c, d, u, A[a + 4], 6, -145523070), u = n(u, s, c, d, A[a + 11], 10, -1120210379), d = n(d, u, s, c, A[a + 2], 15, 718787259), c = n(c, d, u, s, A[a + 9], 21, -343485551), s = g(s, i), c = g(c, o), d = g(d, r), u = g(u, l);
            return [s, c, d, u]
        }

        function i(g) {
            var A, C = "";
            for (A = 0; A < 32 * g.length; A += 8) C += String.fromCharCode(g[A >> 5] >>> A % 32 & 255);
            return C
        }

        function o(g) {
            var A, C = [];
            for (C[(g.length >> 2) - 1] = void 0, A = 0; A < C.length; A += 1) C[A] = 0;
            for (A = 0; A < 8 * g.length; A += 8) C[A >> 5] |= (255 & g.charCodeAt(A / 8)) << A % 32;
            return C
        }

        function r(g) {
            return i(a(o(g), 8 * g.length))
        }

        function l(g, A) {
            var C, I, e = o(g), t = [], n = [];
            for (t[15] = n[15] = void 0, e.length > 16 && (e = a(e, 8 * g.length)), C = 0; C < 16; C += 1) t[C] = 909522486 ^ e[C], n[C] = 1549556828 ^ e[C];
            return I = a(t.concat(o(A)), 512 + 8 * A.length), i(a(n.concat(I), 640))
        }

        function s(g) {
            var A, C, I = "0123456789abcdef", e = "";
            for (C = 0; C < g.length; C += 1) A = g.charCodeAt(C), e += I.charAt(A >>> 4 & 15) + I.charAt(15 & A);
            return e
        }

        function c(g) {
            return unescape(encodeURIComponent(g))
        }

        function d(g) {
            return r(c(g))
        }

        function u(g) {
            return s(d(g))
        }

        function f(g, A) {
            return l(c(g), c(A))
        }

        function m(g, A) {
            return s(f(g, A))
        }

        function p(g, A, C) {
            return A ? C ? f(A, g) : m(A, g) : C ? d(g) : u(g)
        }

        return p
    }()
}), define("mapV2/js/model", function (require, g) {
    function A(g) {
    }

    var C = (require("mapV2/js/mapView"), require("mapV2/js/util/md5"));
    return A.prototype = {
        bubbleAjax: null,
        ditieBubbleAjax: null,
        cardAjax: null,
        houseAjax: null,
        centerAjax: null,
        getAjaxUrl: function (g) {
            return {
                bubble: "map2/search/ershoufang/",
                ditieBubble: "map2/search/stationcommunity/",
                house: "map2/resblock/ershoufanglist/",
                center: "map2/bizcirclecore/",
                resblockCard: "map2/resblock/ershoufangcard/",
                ditieLine: "map2/subway/line/",
                singleDitieInfo: "map2/subway/station/",
                stationInfo: "map2/search/stationershoufang/",
                sug: "map2/suggest/index"
            }[g]
        },

        getTransObj: function (g, A) {
            var C = {};
            switch (g) {
                case"bubble":
                    C = {
                        city_id: window.g_conf.cityId,
                        group_type: A.group,
                        max_lat: A.max_latitude,
                        min_lat: A.min_latitude,
                        max_lng: A.max_longitude,
                        min_lng: A.min_longitude,
                        filters: JSON.stringify(window.g_conf.filter)
                    };
                    break;
                case"ditieBubble":
                    C = {
                        city_id: window.g_conf.cityId,
                        line_id: A.line_id,
                        max_lat: A.max_latitude,
                        min_lat: A.min_latitude,
                        max_lng: A.max_longitude,
                        min_lng: A.min_longitude,
                        filters: JSON.stringify(window.g_conf.filter)
                    }, A.station_id && (C.station_id = A.station_id);
                    break;
                case"house":
                    C = {
                        id: A.ids,
                        order: A.order || 0,
                        page: A.limit_offset + 1,
                        filters: JSON.stringify(window.g_conf.filter)
                    };
                    break;
                case"center":
                    C = {city_id: window.g_conf.cityId, id: A[0].id, filter: null, source: "bkpc"};
                    break;
                case"resblockCard":
                    C = {id: A.ids};
                    break;
                case"ditieLine":
                    C = {city_id: g_conf.cityId};
                    break;
                case"singleDitieInfo":
                    C = {city_id: g_conf.cityId, line_id: A.id};
                    break;
                case"stationInfo":
                    C = {
                        city_id: window.g_conf.cityId,
                        station_id: A.id,
                        filters: JSON.stringify(window.g_conf.filter)
                    };
                    break;
                case"sug":
                    C = {city_id: g_conf.cityId, query: A};
                    break;
                default:
                    C = {}
            }
            return (C.filters && "rp0" == C.filters || "" == C.filters) && delete C.filters, C
        },
        getMd5: function (g) {
            var A = [], I = "";
            for (var e in g) A.push(e);
            A.sort();
            for (var e = 0; e < A.length; e++) {
                var t = A[e];
                "filters" !== t && (I += t + "=" + g[t])
            }

            return I ? (window.md5 = C, C("0p1pfev3vszn4d91rvn9sis797tl07ay" + I)) : ""
        },
        //开始
        ajax: function (g, A, C, I) {
            var e, t = window.ljConf && ljConf.domainConfig && ljConf.domainConfig.apiroot;
            t || (t = "//ajax.ke.com/", "test" == $.env.getEnv() ? t = "//test-ajax.ke.com/" : "dev" == $.env.getEnv() && (t = "//test-ajax.ke.com/"));
            var n = this.getAjaxUrl(g), a = this.getTransObj(g, A);
            a.request_ts = (new Date).getTime();
            var i = this.getMd5(a);
            a.source = "bkpc", a.authorization = i, n && (this[g + "Ajax"] = $.ajax({
                url: t + n,
                dataType: "jsonp",
                data: a,
                method: "GET",
                success: function (A) {
                    this[g + "Ajax"] = null, e.cbFunc && e.cbFunc(A)
                },
                error: function () {
                }
            }), e = this[g + "Ajax"], e.cbFunc = C)
        },
        getBubbles: function (g, A, C) {
            this.ajax("bubble", g, A, C)
        },
        getDitieBubbles: function (g, A, C) {
            this.ajax("ditieBubble", g, A, C)
        },
        formatParams: function (g, A) {
            var C = {};
            return $.each(A, function (A, I) {
                C[I] = g[I]
            }), $.param(C)
        },
        getCards: function (g, A, C) {
            this.ajax("card", g, A, C)
        },
        getCenter: function (g, A) {
            this.ajax("center", g, A)
        },
        getHouseList: function (g, A, C) {
            this.ajax("house", g, A, C)
        },
        getResblockCard: function (g, A) {
            this.ajax("resblockCard", g, A, !1)
        },
        getDitieLine: function (g, A) {
            this.ajax("ditieLine", g, A, !1)
        },
        getSingleDitieLine: function (g, A) {
            this.ajax("singleDitieInfo", g, A, !1)
        },
        getStationInfo: function (g, A) {
            this.ajax("stationInfo", g, A, !1)
        },
        getSug: function (g, A) {
            this.ajax("sug", g, A)
        }
    }, A
}), define("mapV2/js/filter", function (require, g) {
    function A(g, A) {
        for (var C = 10; g;) {
            if (A == g) return !0;
            C--, g = g.parentNode
        }
        return !1
    }

    function C(g, A) {
        var C = g, I = C.val();
        A && clearTimeout(A), A = setTimeout(function () {
            n.getSug(I, function (g) {
                var A = "", C = {source_type: "PC地图找房搜索", fb_item_detail: I};
                if (0 == g.errno) {
                    var e = g.data;
                    for (var t in e) {
                        var n = e[t], a = {};
                        if (a.source_type = "PC地图找房搜索", a.click_position = t, a.item_type = "关键字", a.item_detail = n.text, n && n.strategy_info) for (var o in n.strategy_info) a[o] = n.strategy_info[o], C[o] = n.strategy_info[o];
                        A += '<li class="sug_li CLICKDATA" data-click-evtid="11180" data-click-event="SugClick" data-action="' + $.jsonToQuery(a) + "\" data-info='" + JSON.stringify(n) + "'>" + n.text + '<span class="sug_cnt">约' + n.count + "套在售</span></li>"
                    }
                }
                i.html(A), window.track_handle && window.track_handle.send("11179", "SugRequst", C)
            })
        }, 50)
    }

    function I() {
        $(".show_filter").on("click", function () {
            var g = $(this);
            g.siblings(".filter_content").is(":hidden") ? ($(".filter_content").hide(), g.siblings(".filter_content").show()) : $(".filter_content").hide()
        }), $("li[data-key]").on("click", function () {
            var g = $(this), A = g.parents(".filter_content");
            g.toggleClass("active"), A.find("input").val("")
        });
        var g, I = $(".confirm");
        $(".input_group").find("input").on("input", function () {
            $(this).parents(".filter_content").find(".active").removeClass("active");
            var g = $(this).val();
            $(this).val(g.replace(/[^0-9]+/, ""))
        }), I.on("click", function () {
            var A = $(this), C = A.parents(".filter_content"), I = g_conf.filter, t = {};
            C.find(".active").each(function () {
                var g = $(this), A = g.data("key"), C = g.data("value").replace(/[a-zA-z]*/g, "");
                t[A] = t[A] || [], t[A].push(-1 === C.indexOf(",") ? C : C.split(","))
            });
            var n = C.parents("li").find(".show_filter").find("span"), a = C.find("input");
            if (a.eq(0).val() || a.eq(1).val()) if (0 == C.find(".active").length) {
                var i = a.eq(0).val() || 0, o = a.eq(1).val() || "以上";
                a.eq(0).val() && a.eq(1).val() && (i = Math.min(a.eq(0).val(), a.eq(1).val()), o = Math.max(a.eq(0).val(), a.eq(1).val())), n.text(i + (a.eq(1).val() ? "-" + o + n.data("unit") : n.data("unit") + o))
            } else n.text(n.data("default") + " " + (C.find(".active").length + 1)); else if (0 == C.find(".active").length) {
                var r = A.data("key");
                r.split(",").forEach(function (g) {
                    t[g] = []
                }), n.text(n.data("default"))
            } else 1 == C.find(".active").length ? n.text(C.find(".active").eq(0).find("span").text()) : n.text(n.data("default") + " " + C.find(".active").length);
            if (a.eq(0).val() || a.eq(1).val()) {
                var r = a.data("key");
                if (t[r] = t[r] || [], "" != a.eq(0).val() && "" != a.eq(1).val() && Number(a.eq(0).val()) > Number(a.eq(1).val())) {
                    var l = a.eq(0).val();
                    a.eq(0).val(a.eq(1).val()), a.eq(1).val(l)
                }
                t[r].push([a.eq(0).val() || 0, a.eq(1).val() || null])
            }
            for (var s in t) I[s] = t[s];
            var c = !1;
            for (var s in I) if (0 != I[s].length) {
                c = !0;
                break
            }
            C.hide(), g && clearTimeout(g), g = setTimeout(function () {
                c ? $(".clear_filter").show() : $(".clear_filter").hide(), e.trigger("update_Area"), e.trigger("refresh_house_list")
            }, 100)
        }), $(".cancel").on("click", function () {
            var g = $(this), A = g.parents(".filter_content"), C = g_conf.filter;
            A.find("li[data-key]").removeClass("active");
            for (var I in C) {
                var e = C[I] || [];
                A.find('li[data-key="' + I + '"]').each(function () {
                    var g = $(this);
                    if (g.removeClass("active"), -1 != e.indexOf(g.data("value").replace(/[a-zA-z]*/g, ""))) g.addClass("active"); else if (-1 != g.data("value").indexOf(",") && e) for (var A = 0; A < e.length; A++) {
                        var C = e[A];
                        "object" == typeof C && C[0] == g.data("value").split(",")[0] && g.addClass("active")
                    }
                })
            }
            A.hide()
        });
        a.on("input", function (g) {
            C($(this), void 0)
        }), a.on("focus", function (g) {
            $(this).val() && C($(this), void 0), $(".icon_search").addClass(".icon_search_green")
        });
        var t = -1;
        a.on("keyup", function (g) {
            if ("13" == g.keyCode) {
                if (!a.val()) return e.trigger("resetMap"), !1;
                i.find("li").length && i.find("li").eq(t < 0 ? 0 : t).trigger("click")
            }
            "27" == g.keyCode && i.find("li").length && i.empty(), "38" == g.keyCode ? (i.find("li").removeClass("tmp_focus"), t > 0 && t--, i.find("li").eq(t < 0 ? 0 : t).addClass("tmp_focus")) : "40" == g.keyCode ? (i.find("li").removeClass("tmp_focus"), t < i.find("li").length - 1 && t++, i.find("li").eq(t < 0 ? 0 : t).addClass("tmp_focus")) : t = -1
        }), $(".icon_search").on("click", function () {
            if (!a.val()) return e.trigger("resetMap"), !1;
            if (i.find("li").length) i.find("li").eq(0).trigger("click"); else {
                var g = window.g_conf.searchTmp;
                if (!g) return;
                var A = g.text;
                a.val() == A && e.trigger("sug", g)
            }
        }), i.on("click", ".sug_li", function () {
            var g = $(this), A = g.data("info");
            e.trigger("sug", A), t = 0, setTimeout(function () {
                a.val(A.text), i.empty()
            })
        }), a.on("blur", function (g) {
            setTimeout(function () {
                $(".icon_search").removeClass("icon_search_green")
            }, 50)
        }), $(document.body).on("click", function (g) {
            var C = g.target;
            $(C).hasClass("cancel") || A(C, $(".search_bar")[0]) || (i.empty(), a.trigger("blur")), $(C).hasClass("cancel") || A(C, $(".filters")[0]) || $(".filters").find(".cancel").trigger("click")
        }), $(".clear_filter").on("click", function () {
            $(".filters").find(".active").removeClass("active"), $(".filters").find("input").val(""), I.trigger("click")
        })
    }

    var e = require("mapV2/js/msg"), t = require("mapV2/js/model"), n = new t, a = $("#" + g_conf.sugInputId),
        i = $("#" + g_conf.sugUlId);
    return {
        init: function () {
            I()
        }
    }
}), define("mapV2/js/util/searchStore", function () {
    function g() {
        try {
            return window[t][e] && JSON.parse(window[t][e]) || null
        } catch (g) {
            return null
        }
    }

    function A(g) {
        try {
            window[t][e] = JSON.stringify(g)
        } catch (g) {
        }
    }

    function C(C) {
        var I = g() || [], e = [];
        e.push(C), $.each(I, function (g, A) {
            A.id === C.id && A.type === C.type || e.push(A)
        }), e = e.slice(0, 50), A(e)
    }

    function I() {
        try {
            window[t].removeItem(e)
        } catch (g) {
        }
    }

    var e = g_conf.cityId, t = "localStorage";
    return {
        get: function () {
            return g()
        }, add: function (g) {
            C(g)
        }, clear: function () {
            I()
        }
    }
}), define("mapV2/js/util/ajax", function () {
    return $.ajax
}), define("mapV2/js/util/parseQueryString", function () {
    var g = /([^&=]+)=?([^&]*)/g, A = /\+/g, C = function (g) {
        return decodeURIComponent(g.replace(A, " "))
    };
    return function (A) {
        var I, e = {};
        for (A = A || location.href.split("?")[1] || ""; I = g.exec(A);) {
            var t = C(I[1]), n = C(I[2]);
            "[]" === t.substring(t.length - 2) ? (t = t.substring(0, t.length - 2), (e[t] || (e[t] = [])).push(n)) : e[t] = n
        }
        return e
    }
}), define("mapV2/js/search", function (require, g) {
    function A() {
        return $.trim(d.val())
    }

    function C(g, A) {
        var C = "";
        if (A) {
            var I = localStorage;
            try {
                g = I.getItem("map_search"), g && (g = JSON.parse(g))
            } catch (g) {
            }
        }
        if (g && g.length) {
            var e = g.key || "我就不信还有人查这个文案！";
            g = g.slice(0, 10);
            var C = '<ul class="search_ul">', t = new RegExp(e, "g");
            for (var n in g) {
                var a = g[n];
                C += '<li class="to_cord" data-d=\'' + JSON.stringify(a) + "' data-lat=\"" + a.latitude + '" data-lng="' + a.longitude + '" data-type="' + a.type + '" data-name="' + a.name + '">' + (A ? '<i class="icon_sp icon_time"></i>' : "") + '<div class="search_li_title">' + a.name.replace(t, '<span class="red">' + e + "</span>") + '</div><span class="gray small right">约' + a.count + "套</span></div>", a.alias && (C += '<div class="gray small">' + a.alias + "</div></li>")
            }
            C += "</ul>"
        }
        A && (C += '<a class="list__clear"  href="javascript:;" data-el="clearHistory">搜索历史清除</a>'), c.html(C)
    }

    function I() {
        var g = A();
        x !== g && (g ? n(g, C, t) : C(null, !0)), x = g, y = setTimeout(function () {
            I()
        }, 150)
    }

    function e() {
        clearTimeout(y)
    }

    function t(g) {
        return g && g.data || []
    }

    function n(g, A, C) {
        _({
            url: "/" + config.cur_city_short + "/suggest",
            dataType: "json",
            method: "get",
            data: {city_id: config.cur_city_id, channel: "rent", query: g},
            success: function (I) {
                I = C(I), I.key = g, A(I)
            },
            error: function () {
                A([])
            }
        })
    }

    function a(g) {
        return "district" == g ? 13 : "resblock" == g ? 16 : 14
    }

    function i() {
        d.on("focus", function () {
            I()
        }).on("blur", function () {
            e()
        }), $(".clear_search").on("click", function () {
            $('[data-el="input"]').val(""), C(null, !0)
        }), c.on("click", ".to_cord", function () {
            C(null, !0), h.reset();
            var g = $(this), A = g.data("d");
            "station" == A.type ? setTimeout(function () {
                f.trigger("move_station", {line_id: A.line_id, station_id: A.id})
            }, 150) : "line" == A.type ? setTimeout(function () {
                f.trigger("move_line", {line_id: A.id})
            }, 150) : (v.exit(!0), setTimeout(function () {
                m.centerAndZoom(g.data("lng"), g.data("lat"), a(g.data("type")))
            }, 150));
            var I = localStorage;
            try {
                var e = I.getItem("map_search");
                e = e ? JSON.parse(e) : [];
                var t = !1;
                for (var n in e) e[n].name == g.data("d").name && (t = !0);
                !t && e.unshift(g.data("d")), e.length > 10 && (e.length = 10), I.setItem("map_search", JSON.stringify(e))
            } catch (g) {
            }
            p.find("span").text(g.data("name")), b.find("input").val(""), b.hide()
        }), c.on("click", '[data-el="clearHistory"]', function () {
            var g = localStorage;
            try {
                g.setItem("map_search", "")
            } catch (g) {
            }
            C(null, !0)
        }), $(".search__button").on("click", function () {
            b.find("input").val(""), b.hide()
        })
    }

    function o() {
        M(), S()
    }

    function r() {
        window.g_conf.filter = "", l()
    }

    function l() {
        $("#filter").hide(), $("#search").hide()
    }

    function s() {
        $("#filter").show(), $("#search").show()
    }

    var c, d, u, f = require("mapV2/js/msg"), m = require("mapV2/js/mapView"),
        p = $("#" + window.g_conf.searchEntrance), b = $("#" + window.g_conf.search),
        h = ($("#" + window.g_conf.filterId), require("mapV2/js/filter")), v = require("mapV2/js/ctl"),
        _ = (require("mapV2/js/util/searchStore"), require("mapV2/js/util/ajax")),
        w = require("mapV2/js/util/parseQueryString"), y = null, x = null, k = {
            setInitInputData: function () {
                var g;
                try {
                    g = w().query || ""
                } catch (g) {
                }
                return d.val(g), g
            }, init: function () {
                c = $("#list"), d = b.find('[data-el="input"]'), u = b.find('[data-el="form"]'), i(), this.setInitInputData() || C(null, !0), setTimeout(function () {
                    d.focus()
                }, 200)
            }
        }, S = function () {
            p.on("click", function () {
                b.show()
            })
        }, M = function () {
            $('<div class=""><section class="search" id="search">   <form data-el="form" action="" style="margin-right:3rem">     <i class="search__icon"></i>      <input type="text" placeholder="请输入小区/商圈/地铁" data-el="input" class="search__input" />       <span class="clear_search">&times</span>    </form>     <a class="search__button">取消</a>  </section> <div class="list" id="list"> </div></div>').appendTo(b), k.init()
        };
    return {init: o, hideAndReset: r, show: s, hide: l}
}), define("mapV2/js/scroll", function (require, g) {
    !function (g, A, C, I) {
        if (C) {
            var e = "WebKitCSSMatrix" in g && "m11" in new WebKitCSSMatrix, t = function (g, A) {
                var I = this;
                I.$el = g, I.el = g[0], I.$parent = I.$el.parent(), I.state = {}, I.args = C.extend({
                    wheelSpeed: 20,
                    pressDelay: 200,
                    watch: 200,
                    dir: "",
                    autoHide: !0,
                    activateClass: "mod-scroll--activate",
                    customClass: "",
                    preventDefaultWheel: !1,
                    controller: {barX: "bar-x", barY: "bar-y", thumbX: "thumb-x", thumbY: "thumb-y"}
                }, A), I.init()
            }, n = t.prototype;
            n.init = function () {
                var g = this, I = g.$el, e = g.$parent, t = g.$wrap = C("<div>");
                C.map(g.args.controller, function (A, I) {
                    t.append(g.state["$" + I] = C('<div class="mod-scroll_' + A + '"></div>'))
                }), g.updateState(), g.initLayout(), "static" === e.css("position") && e.css({position: "relative"}), g.state.autoHide && (t.css({display: "none"}), e.on("mouseenter", function () {
                    t.css({display: "block"})
                }).on("mouseleave", function () {
                    !g.state.draging && t.css({display: "none"})
                })), e.css({overflow: "hidden"}).append(t).on(void 0 !== A.onmousewheel ? "mousewheel" : "DOMMouseScroll", function (A) {
                    g.wheelHandle.call(I, A, g)
                }), t.addClass("mod-scroll " + g.args.customClass).on("mousedown", function (A) {
                    A.preventDefault(), g.mouseHandle.call(A.target, A, g)
                }), 0 != g.args.watch && (g.resizeTimer = setInterval(function () {
                    g.detectLayout() && g.resizeHandle.call(g)
                }, g.args.watch)), g.args.onInit && g.args.onInit.call(g)
            }, n.updateState = function () {
                var I = this, e = I.$el, t = I.$parent, n = C.extend(I.state, {
                    dir: function (C, e) {
                        return I.args.dir = C.currentStyle ? C.currentStyle.direction : function () {
                            return (g && g.getComputedStyle(C, null) ? g.getComputedStyle(C, null).getPropertyValue("direction") : A.documentElement.dir) || "ltr"
                        }(), "ltr" === I.args.dir
                    }(I.el),
                    autoHide: 1 == I.args.autoHide,
                    H: t.height(),
                    h: e.outerHeight(),
                    W: t.width(),
                    w: e.outerWidth(),
                    x: I.state.x || 0,
                    y: I.state.y || 0
                }), a = function (g, A) {
                    return Math.floor(Math.min(Math.pow(g, 2) / A, g))
                };
                I.state = C.extend(n, {
                    _x: Math.max(n.w - n.W, 0),
                    _y: Math.max(n.h - n.H, 0),
                    _w: a(n.W, n.w),
                    _h: a(n.H, n.h)
                })
            }, n.initLayout = function () {
                var g = this, A = g.state, C = (g.$el, g.$parent, g.$wrap, {}), I = A.W < A.w, e = A.H < A.h;
                C[A.dir ? "right" : "left"] = 0, C.display = e ? "block" : "none", A.$barY.css(C), A.$thumbY.css(C).css({height: A._h + "px"}), C = {}, C[A.dir ? "left" : "right"] = 0, C.display = I ? "block" : "none", A.$barX.css(C), A.$thumbX.css(C).css({width: A._w + "px"})
            }, n.moveThumb = function (g) {
                var A = this, C = A.state;
                A.scrollTo(C.$thumbX, {x: Math.floor(-C.x * C.W / C.w), y: 0}, g), A.scrollTo(C.$thumbY, {
                    x: 0,
                    y: Math.floor(-C.y * C.H / C.h)
                }, g)
            }, n.resizeHandle = function () {
                var g = this;
                g.state;
                g.updateState(), g.moveThumb(), g.initLayout()
            }, n.selectable = function (g, A) {
                return A || C("body").css("user-select", g ? "none" : "text").attr("unselectable", g ? "on" : "off")[g ? "on" : "off"]("selectstart.scroll", !1)
            }, n.mouseHandle = function (g, I) {
                var e, t = C(this), n = I.state, a = "x", i = n.w, o = n.W, r = {x: 0, y: 0}, l = n.$thumbX, s = !1,
                    c = 0, d = function () {
                        var A;
                        n[a] = I.fixPos(n[a] + o * (("y" === a ? g.pageY - t.offset().top > Math.max(parseFloat(n.$thumbY.css("marginTop")), n.$thumbY.position().top) : g.pageX - t.offset().left > Math.max(parseFloat(n.$thumbX.css("marginLeft")), n.$thumbX.position().left)) ? -1 : 1), a), I.scrollTo(I.$el, {
                            x: n.x,
                            y: n.y
                        }), r[a] = Math.floor(-n[a] * o / i), I.scrollTo(l, r), A = ("x" === a ? g.pageX - t.offset().left : g.pageY - t.offset().top) - r[a], A = A > 0 ? A > ("x" === a ? n._w : n._h) : A < 0, I.args.onScroll && I.args.onScroll.call(I, g), A || (s = !1, c = 1, I.$wrap.removeClass(I.args.activateClass), I.args.onEndPress && I.args.onEndPress.call(I)), s && setTimeout(function () {
                            s && d()
                        }, I.args.pressDelay)
                    };
                this !== n.$thumbY[0] && this !== n.$barY[0] || (a = "y", i = n.h, o = n.H, l = n.$thumbY), this === n.$thumbX[0] || this === n.$thumbY[0] ? (e = {
                    x: g.pageX,
                    y: g.pageY,
                    h: Math.max(parseFloat(t.css("marginTop")), t.position().top),
                    w: Math.max(parseFloat(t.css("marginLeft")), t.position().left)
                }, n.dir || (e.w = e.w - n._w), n.draging = !0, C(A).on("mousemove.scroll", function (g) {
                    n[a] = I.fixPos(-i * ("y" === a ? e.h + g.pageY - e.y : e.w + g.pageX - e.x) / o, a), I.$wrap.addClass(I.args.activateClass), I.selectable(1), I.args.onStartDrag && I.args.onStartDrag.call(I), I.scrollTo(I.$el, {
                        x: n.x,
                        y: n.y
                    }), r[a] = Math.floor(-n[a] * o / i), r[a] = Math.min(r[a], o - ("y" == a ? n._h : n._w)), I.scrollTo(l, r), I.args.onScroll && I.args.onScroll.call(I, g)
                })) : this !== n.$barX[0] && this !== n.$barY[0] || (s = !0, I.$wrap.addClass(I.args.activateClass), I.args.onStartPress && I.args.onStartPress.call(I), d()), C(A).on("mouseup.scroll", function () {
                    C(this).off("mousemove.scroll").off("mouseup.scroll"), !c && I.args.onEndPress && I.args.onEndPress.call(I), s = !1, n.draging = !1, I.$wrap.removeClass(I.args.activateClass), I.selectable(0), I.resizeHandle(), I.args.onEndDrag && I.args.onEndDrag.call(I)
                })
            }, n.wheelHandle = function (g, A) {
                var I = (A.state, C(A.el), function (C) {
                        var I = A.getDelta(g), e = A.args.wheelDir;
                        return e && (I[e] = I["x" === e ? "y" : "x"], I["x" === e ? "y" : "x"] = 0), A.state[C] + I[C] * A.args.wheelSpeed
                    }), e = I("x"), t = I("y"), n = A.fixPos(e, "x"), a = A.fixPos(t, "y"),
                    i = !e && a === A.state.y || !t && n === A.state.x || e < n || t < a;
                !i && g.stopPropagation(), !(!A.args.preventDefaultWheel && i) && g.preventDefault(), A.scrollTo(A.$el, {
                    x: n,
                    y: a
                }), A.state.x = n, A.state.y = a, A.moveThumb(), A.args.onWheel && A.args.onWheel.call(A, g), A.args.onScroll && A.args.onScroll.call(A, g)
            }, n.fixPos = function (g, A) {
                var C = Math.min, I = Math.max, e = -this.state["_" + A];
                return this.state.dir || "x" !== A || (C = Math.max, I = Math.min, e = -e), Math.floor(I(C(g, 0), e))
            }, n.detectLayout = function () {
                var g = this, A = g.state;
                return !(A.h === g.$el.outerHeight() && A.w === g.$el.outerWidth() && A.H === g.$parent.height() && A.W === g.$parent.width())
            }, n.scrollTo = e ? function (g, A) {
                g.css({transform: "translate3d(" + A.x + "px," + A.y + "px, 0)"})
            } : function (g, A, C) {
                !isNaN(A.x) && isFinite(A.x) || (A.x = 0), !isNaN(A.y) && isFinite(A.y) || (A.y = 0);
                var I = this.state.dir ? A.y + "px auto auto " + A.x + "px" : A.y + "px " + -A.x + "px auto auto";
                C ? g.animate({margin: I}, C, "swing") : g[0].style.margin = I
            }, n.goTo = function (g, A, I) {
                var e = this;
                return e.updateState(), C.each(g, function (g, A) {
                    e.state[g] = e.fixPos(A, g)
                }), A ? (e.$parent.addClass("mod-scroll--animate"), setTimeout(function () {
                    e.$parent.removeClass("mod-scroll--animate"), I && I()
                }, 1e3)) : I && I(), e.moveThumb(A), e.initLayout(), e.scrollTo(e.$el, {
                    x: e.state.x,
                    y: e.state.y
                }, A), e
            }, n.getDelta = function (g) {
                g = g.originalEvent || g;
                var A = {delta: 0, x: 0, y: 0};
                return A.delta = void 0 !== g.wheelDelta ? g.wheelDelta / 120 : -(g.detail || 0) / 3, g.axis ? A[g.axis === g.HORIZONTAL_AXIS ? "x" : "y"] = A.delta : void 0 !== g.wheelDeltaX ? (A.x = g.wheelDeltaX / 120, A.y = g.wheelDeltaY / 120) : A.y = A.delta, A
            }, n.destroy = function () {
                var g = this;
                g.resizeTimer && clearInterval(g.resizeTimer)
            }, console.log(), C.fn.scrollable = function (g) {
                return new t(this, g)
            }
        }
    }(window, document, $)
}), define("mapV2/js/house", function (require, g) {
    function A(g) {
        return $.each(g, function (g, A) {
            A.house_area_origin = A.square, A.house_area = Math.floor(A.square), A.community_names = A.communityName, A.tag = '<p class="content__item__tag--wrapper tags">';
            for (var C in A.tags) {
                var I = A.tags[C];
                A.tag += '<i class="tag ' + I[0] + '">' + I[1] + "</i>"
            }
            A.tag += "</p>", A.duration ? (A.wtf_any = A.duration, A.replace_com = "通勤时间" + Math.ceil(A.duration / 60) + "分钟") : (A.wtf_any = "", A.replace_com = A.community_name), A.title || (A.title = A.communityName + "&nbsp;" + A.roomNum), A.imgSrc = (A.imgSrc || M).replace("280x210", "116x116"), A.defaultImgSrc = T
        }), g
    }

    function C(g, A) {
        return A ? '<a class="resblock_name" href="' + A.url + '">' + A.resblockName + '</a><div class="resblock_info"><p>' + function (g) {
            var A = [];
            return g.buildingFinishYear && A.push(g.buildingFinishYear + "年"), g.buildingType && A.push(g.buildingType), g.buildingCnt && A.push(g.buildingCnt + "栋"), A.join('<span class="dot">·</span>')
        }(A) + '</p><p><span class="big">' + (A.unitPrice ? A.unitPrice + "元/平" : "暂无均价") + "</span> " + A.bdaTime + '参考均价</p></div><div class="resblock_info right">' + (g.name ? '<a class="agent_img" target="_blank" href="javascript:;"><img src="' + g.photoPath + '"/></a><p class="agent_name">' + g.name + '<a class="beikeim-createtalkAll new-talk LOGCLICK" data-log_id="20001" data-bl="agentim" data-el="' + g.agentUcid + '"  title="在线咨询" data-role="beikeim-createtalk" data-ucid="' + g.agentUcid + '"><span class="im-icon"></span>沟通</a></p><p class="agent_phone">' + g.fourPhoneOne + "</p>" : "") + "</div>" : ""
    }

    function I(g) {
        if (!g) return "";
        var A = ["pid=bigc_pc_ershou", "source_type=PC地图找房小区吊顶展位", "community_id=" + g.info.id, "agent_ucid=" + g.agentUcid, "e_plan=" + g.digVTop, "type=" + ("resblock" == g.type ? "community" : "resarea")].join("&");
        A = "data-action=" + A;
        var C = "";
        if (g.tags) for (var I = 0; I < g.tags.length; I++) (g.agentMark && I < 2 || !g.agentMark && I < 3) && (C += "<span>" + g.tags[I] + "</span>");
        return '<div class="agentCardAgentInfo VIEWDATA" data-view-event="ModuleExpo" data-view-evtid="13108" ' + A + '><a href="javascript:;>" target="_blank" class="agentCardAgentImg CLICKDATA" data-click-evtid="12635" data-click-event="WebClick" ><img src="' + (g.photoPath || g_conf.defaultImg) + '.84x110.jpg" alt="小区顾问"></a><div class="cardAgentInfo"><div class="cardAgentNameContainer"><div target="_blank" class="cardAgentName" >' + g.name + '</div></div><div class="cardAgentPhone"><span class="phone_num">' + g.fourPhoneOneTop + '</span><a class="agentIcon CLICKDATA"  data-click-event="IMClick" data-source-extends=\'' + $.jsonToQuery({community_id: +g.info.id}) + "&" + $.jsonToQuery(g.imInfo) + '\' data-bl="agedatnt_im" data-ucid="' + g.agentUcid + '" data-bl="agentim" data-source-port="pc_beike_ershouplat_list_ditu_diaoding" data-role="beikeim-createtalk" data-msg-payload="您好，我想咨询' + g.info.name + '小区" data-click-evtid="13109" ' + A + '></a></div><div class="cardAgentDesc">' + g.desc + '</div><div class="jjr_card_div">' + (g.agentMark ? '<span class="star_jjr">' + g.agentMark + "</span>" : "") + C + "</div></div></div>"
    }

    function e(g, A) {
        A || L || (L += '<div class="house_list_top"><div class="black">本小区在售<span class="green">' + g.total + '</span>套房源</div><div class="sort_group"><a class="active" data-ordertype="0"  data-noorder="1">默认</a><a data-ordertype="2">按总价</a><a data-ordertype="1">按面积</a><a data-ordertype="3" data-noorder="1">最新</a></div></div>', L = $(L)), L.prependTo(v)
    }

    function t(g, C) {
        var I = "";
        if (C || ($(".wrapped_div").remove(), $(".wrapped_div_scroll").remove(), $(".list_empty").remove(), k = !1), !g || !g.list || !function (g) {
                var A = 0;
                for (var C in g) {
                    A++;
                    break
                }
                return A
            }(g.list)) return k = !0, C ? "" : j.noDataItem;
        g = A(g.list), C || (I += '<div class="wrapped_div_scroll"></div>', I += '<div class="wrapped_div">');
        var e = 0;
        for (var t in g) g[t].keys = e, g[t].strategy_str = function (g) {
            var A = "";
            for (var C in g) A += "&" + C + "=" + g[C];
            return A
        }(g[t].strategy_info), e++;
        return $.each(g, function (g, A) {
            I += $.replaceTpl(j.roomListItem, A)
        }), !C && (I += "</div>"), I
    }

    function n() {
        $(".close_list").on("click", function () {
            h.toggleClass("active"), $(this).show()
        }), m.on("clear_house_card", function () {
            c()
        }), $(document.body).on("click", ".sort_group a", function () {
            var g = $(this), A = g.data("ordertype"), C = g.data("order") || "0",
                I = A + "" + (g.data("noorder") ? "" : C);
            g.siblings("a").removeClass("active").data("order", 1), g.addClass("active"), g.data("order", 1 - C), m.trigger("refetchHouse", {order: I}), b = I
        }), $(document.body).on("click", ".resblock_label", function () {
            var g = $(this).data("position").split(","), A = new BMap.Point(g[0], g[1]);
            p.getMap().centerAndZoom(A, 16)
        })
    }

    function a() {
        n()
    }

    function i() {
        u && u.goTo({y: 0})
    }

    function o(g, A, n) {
        x = 1, S = Math.ceil((A.data.ershoufang_info.total || 0) / 10), _.html(A.data.total || 0), $(t(A.data.ershoufang_info)).appendTo(v), window.track_handle && window.track_handle.checkNodes(), n || (L && L.remove(), L = ""), L ? $(".house_list_top").find(".green").text(A.data.ershoufang_info.total) : (b = 0, e(A.data.ershoufang_info));
        var a = window.g_conf.houseListorder || 0;
        $(".wrapped_div").on("scroll", function (g) {
            if (!k) {
                var A = $(this).scrollTop(), C = $(this)[0].scrollHeight;
                if ($(this)[0].offsetHeight + A + 10 > C) {
                    if (x >= 200 || x >= S) return;
                    clearTimeout(f), f = setTimeout(function () {
                        m.trigger("update_house_add_" + g_conf.curChannel, {offset: x, order: b})
                    }, 100)
                }
            }
        }), setTimeout(function () {
            $(".sort_group").find("a").removeClass("active");
            var g = (a + "")[0];
            $(".sort_group").find('a[data-ordertype="' + g + '"]').addClass("active"), (a + "").length > 1 && $(".sort_group").find('a[data-ordertype="' + g + '"]').attr("data-order", (a + "")[1])
        }), w.html(C(A.data.agent_info, A.data.resblock_info)), y.html(I(A.data.agent_card)), i(), n || h.addClass("active"), setTimeout(function () {
            window.track_handle && window.track_handle.checkNodes()
        }, 1e3)
    }

    function r(g, A) {
        $(t(g.data.ershoufang_info, !0)).appendTo($(".wrapped_div")), x = A + 1
    }

    function l() {
        _.html(0), v.html(t(null)), h.removeClass("active"), $("#filter").show(), $("#search").show()
    }

    function s(g) {
        g = g.data;
        var A,
            C = '<div class="resblock_card"><div class="img_frame"><img src="' + (g.picture || T) + '"/></div><p class="black">小区均价：' + (g.unitPrice ? g.unitPrice + "元/平" : "暂无数据") + '</p><p class="black mgb20">' + g.resblockName + "(" + g.houseSellNum + '套)</p><p class="resblock_card_desc">' + g.buildingFinishYear + "年/" + g.houseType + "/" + g.buildingCnt + '栋</p><p class="resblock_card_desc">' + g.properties + "</p></div>",
            I = new BMap.Size(0, -200);
        A = new BMap.Label(C, {
            position: new BMap.Point(g.lng, g.lat),
            offset: I
        }), A.setZIndex(1e4), A.setStyle({
            border: "none",
            "border-radius": "2px",
            "box-shadow": "red",
            "border-image": "none",
            "font-family": "Hiragino Sans GB",
            transform: "translate(-50%, 0)",
            "-webkit-transform": "translate(-50%, 0)",
            "-ms-transform": "translate(-50%, 0)",
            "-o-transform": "translate(-50%, 0)",
            "z-index": 1e5
        }), c(), d = A, p.getMap().addOverlay(A)
    }

    function c() {
        p.getMap().removeOverlay(d)
    }

    require("mapV2/js/scroll")
    ;var d, u, f, m = require("mapV2/js/msg"), p = require("mapV2/js/mapView"), b = 0, h = $("#" + g_conf.houseListId),
        v = h.find(".r-content"), _ = h.find(".r-hd_i"), w = $("#" + g_conf.agentInfo),
        y = $("#" + g_conf.agentInfoDetail), x = 1, k = !1, S = 0,
        M = "https://s1.ljcdn.com/pegasus/redskull/images/common/default_house_list.png",
        T = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJ4AAAB2CAYAAAA5kiqUAAAACXBIWXMAAAsTAAALEwEAmpwYAAA482lUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4KPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMxMTEgNzkuMTU4MzI1LCAyMDE1LzA5LzEwLTAxOjEwOjIwICAgICAgICAiPgogICA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPgogICAgICA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIgogICAgICAgICAgICB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iCiAgICAgICAgICAgIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIKICAgICAgICAgICAgeG1sbnM6cGhvdG9zaG9wPSJodHRwOi8vbnMuYWRvYmUuY29tL3Bob3Rvc2hvcC8xLjAvIgogICAgICAgICAgICB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIKICAgICAgICAgICAgeG1sbnM6c3RFdnQ9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZUV2ZW50IyIKICAgICAgICAgICAgeG1sbnM6dGlmZj0iaHR0cDovL25zLmFkb2JlLmNvbS90aWZmLzEuMC8iCiAgICAgICAgICAgIHhtbG5zOmV4aWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20vZXhpZi8xLjAvIj4KICAgICAgICAgPHhtcDpDcmVhdG9yVG9vbD5BZG9iZSBQaG90b3Nob3AgQ0MgMjAxNSAoTWFjaW50b3NoKTwveG1wOkNyZWF0b3JUb29sPgogICAgICAgICA8eG1wOkNyZWF0ZURhdGU+MjAxOC0wMS0xNVQxMDo0MzowOSswODowMDwveG1wOkNyZWF0ZURhdGU+CiAgICAgICAgIDx4bXA6TW9kaWZ5RGF0ZT4yMDE4LTAxLTI5VDE4OjAxOjIxKzA4OjAwPC94bXA6TW9kaWZ5RGF0ZT4KICAgICAgICAgPHhtcDpNZXRhZGF0YURhdGU+MjAxOC0wMS0yOVQxODowMToyMSswODowMDwveG1wOk1ldGFkYXRhRGF0ZT4KICAgICAgICAgPGRjOmZvcm1hdD5pbWFnZS9wbmc8L2RjOmZvcm1hdD4KICAgICAgICAgPHBob3Rvc2hvcDpDb2xvck1vZGU+MzwvcGhvdG9zaG9wOkNvbG9yTW9kZT4KICAgICAgICAgPHBob3Rvc2hvcDpEb2N1bWVudEFuY2VzdG9ycz4KICAgICAgICAgICAgPHJkZjpCYWc+CiAgICAgICAgICAgICAgIDxyZGY6bGk+eG1wLmRpZDoxZGVjNGQ1OC04OGY0LTQ4NGItYTVlYS1iNzE1MzlkZjZkMDE8L3JkZjpsaT4KICAgICAgICAgICAgPC9yZGY6QmFnPgogICAgICAgICA8L3Bob3Rvc2hvcDpEb2N1bWVudEFuY2VzdG9ycz4KICAgICAgICAgPHhtcE1NOkluc3RhbmNlSUQ+eG1wLmlpZDpkNDVkMzFiOS1lZGE1LTQxZDgtYjllMC01YzE4NDlhOTVjNGM8L3htcE1NOkluc3RhbmNlSUQ+CiAgICAgICAgIDx4bXBNTTpEb2N1bWVudElEPnhtcC5kaWQ6ZDQ1ZDMxYjktZWRhNS00MWQ4LWI5ZTAtNWMxODQ5YTk1YzRjPC94bXBNTTpEb2N1bWVudElEPgogICAgICAgICA8eG1wTU06T3JpZ2luYWxEb2N1bWVudElEPnhtcC5kaWQ6ZDQ1ZDMxYjktZWRhNS00MWQ4LWI5ZTAtNWMxODQ5YTk1YzRjPC94bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ+CiAgICAgICAgIDx4bXBNTTpIaXN0b3J5PgogICAgICAgICAgICA8cmRmOlNlcT4KICAgICAgICAgICAgICAgPHJkZjpsaSByZGY6cGFyc2VUeXBlPSJSZXNvdXJjZSI+CiAgICAgICAgICAgICAgICAgIDxzdEV2dDphY3Rpb24+Y3JlYXRlZDwvc3RFdnQ6YWN0aW9uPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6aW5zdGFuY2VJRD54bXAuaWlkOmQ0NWQzMWI5LWVkYTUtNDFkOC1iOWUwLTVjMTg0OWE5NWM0Yzwvc3RFdnQ6aW5zdGFuY2VJRD4KICAgICAgICAgICAgICAgICAgPHN0RXZ0OndoZW4+MjAxOC0wMS0xNVQxMDo0MzowOSswODowMDwvc3RFdnQ6d2hlbj4KICAgICAgICAgICAgICAgICAgPHN0RXZ0OnNvZnR3YXJlQWdlbnQ+QWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKE1hY2ludG9zaCk8L3N0RXZ0OnNvZnR3YXJlQWdlbnQ+CiAgICAgICAgICAgICAgIDwvcmRmOmxpPgogICAgICAgICAgICA8L3JkZjpTZXE+CiAgICAgICAgIDwveG1wTU06SGlzdG9yeT4KICAgICAgICAgPHRpZmY6T3JpZW50YXRpb24+MTwvdGlmZjpPcmllbnRhdGlvbj4KICAgICAgICAgPHRpZmY6WFJlc29sdXRpb24+NzIwMDAwLzEwMDAwPC90aWZmOlhSZXNvbHV0aW9uPgogICAgICAgICA8dGlmZjpZUmVzb2x1dGlvbj43MjAwMDAvMTAwMDA8L3RpZmY6WVJlc29sdXRpb24+CiAgICAgICAgIDx0aWZmOlJlc29sdXRpb25Vbml0PjI8L3RpZmY6UmVzb2x1dGlvblVuaXQ+CiAgICAgICAgIDxleGlmOkNvbG9yU3BhY2U+NjU1MzU8L2V4aWY6Q29sb3JTcGFjZT4KICAgICAgICAgPGV4aWY6UGl4ZWxYRGltZW5zaW9uPjE1ODwvZXhpZjpQaXhlbFhEaW1lbnNpb24+CiAgICAgICAgIDxleGlmOlBpeGVsWURpbWVuc2lvbj4xMTg8L2V4aWY6UGl4ZWxZRGltZW5zaW9uPgogICAgICA8L3JkZjpEZXNjcmlwdGlvbj4KICAgPC9yZGY6UkRGPgo8L3g6eG1wbWV0YT4KICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAKPD94cGFja2V0IGVuZD0idyI/PlQxZPIAAAAgY0hSTQAAeiUAAICDAAD5/wAAgOkAAHUwAADqYAAAOpgAABdvkl/FRgAABIhJREFUeNrs3e12ojoARuGXQEAUtT33f5EVP4AQwvmhxzXTKmK1PdNhP7+ddsraJSQEGjnnegHfzHAIQHggPIDwQHgA4YHwAMID4QGEB8ID4QGEB8IDCA+EBxAeCA8gPBAeQHggPBAeQHggPIDwQHgA4YHwAMID4QGEB8ID4QGEB8IDCA+EBxAeCA8YIeEQjOe7oKr2ci4ohHD8zTVGqTXK80RJzO/xWBF/2Wec3b7VoWoHPzPPrRYLq4jDRXiPCqHXZtuobcOoz9vEaL3KZAz5Ed4ntW3QZtsohPsOkTGRVstUqY05iIR3n0Pltdu7h75GsbCa55aDSXi39b203TWqm27wc3EcKVIk3w0PwVkWa1Vkihh5Ce+aruu1KZvBmKJIKhap8tlxQaCuvbZ7p37gKCax0XqVKmbWS3jvNa5TuXXqBwqKTaT1KlOS/B6Q98drwa7rB4KNtCpSZRnXfYR3MmapJLWxVsv06mw19L3KrZNzw0P0PLcqFlz3TTq8EE6xtMOxLOZWi/m4WPaHVvvDYxET3t+8VOKDyrJRF24Mj8tUWXrf8Dhm2DanYdsmhvCmoqqPSyW3JwSZ4vhzZ6WuOy48ez9+okJ4f/NSyd6prv3g52ZZrOUTlkCOSzNOdXPr+yVaFumkllwmE14Ivd7K4TOQdDwDzfPnnoGq2mu7G16MThKjlwndapvMBcZ27wajMybS63r29OgkKZ8lel3PBqPyPtyMk/B+oKFlDmuN/nmZydqvOxxjvset2TXh/UCxufyjzvPbZ6OnHewbZ9UpLa9MJrz363BRJK2WmYpF+u3/l2KRar38OHkZu1bI5OKHaX1Q03hFUaRZlnx6qeRZuq5XVXtJvbI0+dKhnvAA8bCPQugHF5Kfre9198bSv1Ey5eB+3dI+z5Mvv97b7Z0OlT/PcldF9r8P95zxvtl25357juJQ+dP11teoan+OTjpuq5/Suh3hnTQX1vV+DePp4V342q7tvnWYJ7w/4Qe/sGbWdeFLFnHbNlzc1WyiaLJb4icb3rWtTrt9+/xh/cpDQ1PejTzZ8K5tRfI+3NyNfI9D5a/eI57idqjJh5ckZvCs17jHh9zGdVcfkUzT+MOzG4Q3EcXi+h64Tdk8NMuta6+ybK5/7/m0n7uYdHhxHA3eH93unDY3tsd/mKCE4yOS5c7p2r9azO2kz3YSt8wkSW9lM7htKpKUZYlmWSxrjaJ3p8m+79W2QXXTqXF+cIkktbFe1tnUDznh/RfO26ZR68e9mCc20Xk5JvT94PO0768rX9fZh3AJb+rxlePfCnUva49b24mO8C5f1+3dxbsMj8hnyeBEhvAg6Xgra7drb76Q5+bQGhsVheV1ZYR355JI06mq2tHXfudhNTHKc6sZ70khvEd0XS/Xdud7riH05z115jTRSGIja41SG092qxPh4Y/HC9tAeCA8gPBAeADhgfAAwgPhAYQHwgPhAYQHwgMID4QHEB4IDyA8EB5AeCA8EB5AeCA8gPBAeADhgfAAwgPhAYQHwgPhAYQHwgMID4QHEB5+nH8HAPICFBD5SB1eAAAAAElFTkSuQmCC",
        j = {
            roomListItem: '<li class="list-item content__item CLICKDATA VIEWDATA" data-click-evtid="11182" data-view-evtid="11722" data-view-event="ItemExpo" data-click-event="SearchClick" data-action="source_type=PC地图找房搜索&housedel_id=#{houseId}&resblock_id=#{communityId}&&click_position=#{keys}#{strategy_str}"><a href="#{viewUrl}" target="_blank" title="#{title}" data-community="#{communityId}"><img class="content__item__aside"  src="#{imgSrc}" onerror="this.src=\'#{defaultImgSrc}\'"/><div class="content__item__main"><p class="content__item__bottom">#{price}<span>万</span></p><p class="content__item__title">#{title}</p><p class="content__item__content">#{roomNum}/#{square}平米/#{orientation}</p>#{tag}</div></a></li>',
            roomTagItem: "",
            noDataItem: '<div class="list_empty"><i class="icon icon_list_empty"></i><p>没有找到符合条件的房源</p></div>',
            subwayItem: ""
        }, L = "";
    return {add: r, render: o, init: a, scrollTop: i, clear: l, renderHouseCard: s, removeHouseCard: c}
}), define("mapV2/js/area", function (require, g) {
    function A() {
        var g = z.getBounds();
        return {
            min_longitude: g.min_longitude,
            max_longitude: g.max_longitude,
            min_latitude: g.min_latitude,
            max_latitude: g.max_latitude,
            group: a(z.getZoom()),
            center: z.getCenter()
        }
    }

    function C() {
        var g = z.getBounds(), A = V.getParam(), C = {
            min_longitude: g.min_longitude,
            max_longitude: g.max_longitude,
            min_latitude: g.min_latitude,
            max_latitude: g.max_latitude,
            group: t(z.getZoom()),
            line_id: A.line_id
        };
        return "community" == C.group && (C.station_id = T), C
    }

    function I() {
        var g = G.getParam();
        return {
            min_longitude: g.min_longitude,
            max_longitude: g.max_longitude,
            min_latitude: g.min_latitude,
            max_latitude: g.max_latitude,
            group: "community"
        }
    }

    function e(g) {
        return "3"
    }

    function t(g) {
        return g <= 11 ? "max" : g <= 14 ? "station" : "community"
    }

    function n(g) {
        return g <= 14 ? "5" : g >= 15 ? "3" : void 0
    }

    function a(g) {
        return g <= 13 ? "district" : g >= 16 ? "community" : "bizcircle"
    }

    function i(g) {
        return g <= 13 ? "5" : g >= 16 ? "3" : "2"
    }

    function o(g) {
        return g < 14 ? 14 : g < 16 ? 16 : g
    }

    function r(g) {
        var A = [], C = z.getBounds(), I = {
            min_longitude: parseFloat(C.min_longitude),
            max_longitude: parseFloat(C.max_longitude),
            min_latitude: parseFloat(C.min_latitude),
            max_latitude: parseFloat(C.max_latitude)
        };
        return $.each(g, function (g, C) {
            var e = parseFloat(C.longitude), t = parseFloat(C.latitude);
            e <= I.max_longitude && e >= I.min_longitude && t <= I.max_latitude && t >= I.min_latitude && A.push(C)
        }), A
    }

    function l(g) {
        var A;
        A = "ditie" == window.g_conf.model ? n(z.getZoom()) : "circle" == window.g_conf.model ? e(z.getZoom()) : i(z.getZoom());
        var C = {total_count: g && g.data && g.data.total_count, visible_count: g && g.data && g.data.visible_count};
        g = g && g.data && g.data.list || [];
        var I = [];
        for (var t in g) if ("circle" == window.g_conf.model) {
            var a = new BMap.Point(g[t].longitude, g[t].latitude);
            G.isInBound(a) && I.push(g[t])
        } else I.push(g[t]);
        return "circle" == window.g_conf.model && (C.visible_count = 0, $.each(I, function (g, A) {
            C.visible_count += parseInt(A.count)
        })), g = I, g = r(g || []), $.each(g, function (g, C) {
            C.bubbleLevel = A
        }), g.extra_info = C, g
    }

    function s(g, A, C, I) {
        if (g) {
            var e = g, t = void 0 !== A;
            C && (t = !1);
            var n, a = [];
            R.houseAjax && (R.houseAjax.cbFunc = null, R.houseAjax = null), $.each(g, function (g, A) {
                a.push(A.id)
            }), n = {
                ids: a.join(","),
                limit_offset: A || 0,
                limit_count: 10,
                order: I || 0
            }, g.length ? R.getHouseList(n, function (g) {
                c(g, t, A, e)
            }) : c({
                data: {
                    total_count: 0,
                    list: []
                }
            }, t, A, e), window.g_conf.houseListorder = 0, window.g_conf.currentHouse = {ids: a.join(",")}
        }
    }

    function c(g, A, C, I, e) {
        var t = {};
        if (t.source_type = "PC地图找房搜索", g && g.data && g.data.ershoufang_info && g.data.ershoufang_info.list) for (var n in g.data.ershoufang_info.list) {
            var a = g.data.ershoufang_info.list[n];
            if (a.strategy_info) {
                for (var i in a.strategy_info) t[i] = a.strategy_info[i];
                break
            }
        }
        window.track_handle && window.track_handle.send("11181", "SearchRequst", t), A ? (W.add(g, C), window.track_handle && window.track_handle.checkNodes()) : (W.render(I, g, e), window.track_handle && window.track_handle.checkNodes())
    }

    function d(g) {
        W.renderHouseCard(g)
    }

    function u(g) {
        Z.clear(), Z.add(g), M && (M = 0, D.trigger("showTips", g.extra_info))
    }

    function f(g, A) {
        P && (P.remove(), P = null), z.getZoom() <= 13 || g && (P = $('<div class="count_hint">显示' + g + "个房源中的" + A + "个，拖动查看更多</div>"), P.appendTo(document.body))
    }

    function m() {
        P && P.remove(), P = null
    }

    function p(g, A) {
        R.bubbleAjax && (R.bubbleAjax.cbFunc = null, R.bubbleAjax = null), R.getBubbles(g, function (g) {
            g = l(g), f(g.extra_info.total_count, g.extra_info.visible_count), H = g, u(g)
        })
    }

    function b(g, A) {
        "max" != g.group && (R.ditieBubbleAjax && (R.ditieBubbleAjax.cbFunc = null, R.ditieBubbleAjax = null), R.getDitieBubbles(g, function (g) {
            f(g.total_count, g.visible_count), g = l(g), H = g, u(g)
        }))
    }

    function h(g) {
        Z.addWhiteBubble(g)
    }

    function v(g) {
        Z.clearAll(), g_conf.curLineMap && (g_conf.curLineMap.clearResults(), g_conf.curLineMap = null), addingSubwayLine = !0, g_conf.curLineMap = new BMap.BusLineSearch(z.getMap(), {
            renderOptions: {},
            onPolylinesSet: function (g) {
            },
            onGetBusListComplete: function (g) {
                if (g) {
                    var A = g.getBusListItem(0);
                    g_conf.curLineMap.getBusLine(A), setTimeout(function () {
                        addingSubwayLine = !1
                    }, 1e3)
                }
            },
            onGetBusLineComplete: function (g) {
                var A = z.getMap();
                B && A.removeOverlay(B);
                var C = g.getPolyline();
                setTimeout(function () {
                    var I = g.getNumBusStations(), e = Math.floor(I / 2), t = (g.getBusStation(e), C.getPath());
                    B = new BMap.Polyline(t, {strokeColor: "#D22020", strokeWeight: 8, strokeOpacity: 1});
                    for (var n = [], a = [], i = 0; i < t.length; i++) n.push(t[i].lat), a.push(t[i].lng);
                    var o = Math.max.apply(null, n), r = Math.min.apply(null, n), l = Math.max.apply(null, a),
                        s = Math.min.apply(null, a);
                    A.centerAndZoom(new BMap.Point((s + l) / 2, (o + r) / 2), 13), D.trigger("showWhiteOverlay"), setTimeout(function () {
                        if (A.addOverlay(B), N) {
                            var g = N;
                            N = null, D.trigger("showDetailBySug", g)
                        }
                    }, 100)
                }, 50)
            }
        }), setTimeout(function () {
            g_conf.curLineMap.getBusList("地铁" + g), g_conf.curLineMap.setMarkersSetCallback(function (g) {
            })
        }, 100)
    }

    function _(g, A) {
        var C = g.longitude - A.longitude, I = g.latitude - A.latitude;
        return res = Math.abs(C) - Math.abs(I), res > 0 ? 0 : 1
    }

    function w() {
        D.on("sug", function (g, A) {
            window.g_conf.searchTmp = A;
            var C = A.type;
            if ($(".houseList").removeClass("active"), "bizcircle" === C || "district" === C) {
                if (V.exit(), z.centerAndZoom(A.longitude, A.latitude, "bizcircle" === C ? 14 : 13), "bizcircle" == C) {
                    var I = 0;
                    setTimeout(function () {
                        var g = setInterval(function () {
                            I++, I > 10 && clearInterval(g), $('.bubble-2[data-id="' + A.id + '"]').length && ($(".bubble-2").removeClass("hover"), $('.bubble-2[data-id="' + A.id + '"]').addClass("hover"), clearInterval(g), g = 0)
                        }, 1e3)
                    }, 1e3)
                }
            } else if ("community" === C) {
                V.exit(), z.centerAndZoom(A.longitude, A.latitude, 16);
                var e = 0, t = setInterval(function () {
                    e++, e > 10 && clearInterval(t), $('.bubble-3[data-id="' + A.id + '"]').length && ($('.bubble-3[data-id="' + A.id + '"]').trigger("click"), clearInterval(t), t = 0)
                }, 1e3)
            } else "subway_line" !== C && "subway_station" !== C || (setTimeout(function () {
                var g = $("#" + g_conf.sugInputId), I = $("#" + g_conf.sugUlId);
                g.val(A.text), I.empty();
                var e = "subway_line" === C ? A.id : A.line_id.split(",")[0];
                $('.ditie_li[data-id="' + e + '"]').trigger("click")
            }), "ditie" != window.g_conf.model && $(".toSubway").trigger("click"), "subway_station" === C && (N = A))
        }), D.on("refetchHouse", function (g, A) {
            var C = {ids: window.g_conf.currentHouse.ids, limit_offset: 0, limit_count: 10, order: A.order};
            R.getHouseList(C, function (g) {
                c(g, !1, 0, {}, !0)
            }), window.g_conf.houseListorder = A.order
        }), D.on("renderDitie", function (g) {
            R.getDitieLine({}, function (g) {
                V.renderDitie(g)
            })
        }), D.on("destory_ditie", function (g) {
            for (; label = Y.shift();) z.getMap().removeOverlay(label)
        }), D.on("clearStationInfo", function (g, A) {
            L && z.getMap().removeOverlay(L), L = null
        }), D.on("clearStationInfo", function (g, A) {
            L && z.getMap().removeOverlay(L)
        }), D.on("showStationInfo", function (g, A) {
            R.getStationInfo(A, function (g) {
                L && z.getMap().removeOverlay(L), g = g.data;
                var A = g.station_name, C = (g.count, g.longitude), I = g.latitude,
                    e = new BMap.Label('<div class="station_card"><p>' + A + "</p><p>在售(" + g.count + "套)</p></div>", {
                        position: new BMap.Point(C, I),
                        offset: new BMap.Size(0, -60)
                    });
                e.setStyle({
                    border: "none",
                    backgroundColor: "transparent",
                    transform: "translate(-50%, 0)",
                    "-webkit-transform": "translate(-50%, 0)",
                    "-o-transform": "translate(-50%, 0)",
                    "-ms-transform": "translate(-50%, 0)",
                    "font-family": "Hiragino Sans GB"
                }), L = e, z.getMap().addOverlay(e)
            })
        }), D.on("showWhiteOverlay", function () {
            var g = z.getMap();
            k && g.removeOverlay(k), k = new BMap.Polyline([], {
                strokeColor: "rgba(255,255,255,0.7)",
                strokeWeight: 1e6,
                enableMassClear: !1,
                strokeOpacity: 1
            });
            var A = g.getBounds().getNorthEast(), C = new BMap.Point(A.lng + 1, A.lat - 1),
                I = (g.getBounds().getSouthWest(), new BMap.Point(A.lng - 1, A.lat + 1));
            k.setPath([C, I]), console.log(C, I), setTimeout(function () {
                g.addOverlay(k)
            }, 50)
        }), D.on("removeWhiteOverlay", function () {
            k && x.removeOverlay(k), k = null
        }), D.on("removeDitieLabel", function () {
            for (; j = E.shift();) z.getMap().removeOverlay(j)
        }), D.on("showSingleDitieLine", function (g, A) {
            var C = A.name;
            R.getSingleDitieLine(A, function (g) {
                for (v(C); Y.length;) {
                    var A = Y.shift();
                    z.getMap().removeOverlay(A)
                }
                for (; j = E.shift();) z.getMap().removeOverlay(j);
                for (var I = [0, 0], e = 0; e < g.data.length; e++) {
                    var t, A = g.data[e];
                    if (e + 1 < g.data.length) {
                        var n = g.data[e + 1];
                        t = _(A, n)
                    } else {
                        var n = g.data[e - 1];
                        t = _(n, A)
                    }
                    var a = ["station_name_up", "station_name_down", "station_name_left", "station_name_right"],
                        i = new BMap.Label('<div class="station ' + (A.is_transfer_station ? "icon_transfer_station" : "") + ' " data-lid="' + A.line_id + '"data-name="' + A.station_name + '" data-id="' + A.station_id + '" data-latitude="' + A.latitude + '"  data-longitude="' + A.longitude + '"><span class="station_name ' + a[I[t] + (0 == t ? 0 : 2)] + '">' + A.station_name + "</span></div>", {
                            position: new BMap.Point(A.longitude, A.latitude),
                            offset: new BMap.Size(-5, -5),
                            enableMassClear: !1
                        });
                    I[t] = 1 - I[t], i.setStyle({
                        border: "none",
                        backgroundColor: "transparent",
                        zIndex: 4
                    }), Y.push(i), z.getMap().addOverlay(i);
                    var o = new BMap.Label('<div class="station_icon"></div>', {
                        position: new BMap.Point(A.longitude, A.latitude),
                        offset: new BMap.Size(-16, -40),
                        enableMassClear: !1
                    });
                    o.setStyle({border: "none", backgroundColor: "transparent"}), z.getMap().addOverlay(o), E.push(o)
                }
            })
        }), D.on("ditiePolyline", function () {
            B && z.getMap().removeOverlay(B)
        }), D.on("subwayIcoShow", function (g) {
            $(".station_icon").show()
        }), D.on("refresh_house_list", function (g) {
            s(window.g_conf.bubbleData, 0, 1), z.isClickEvent = !1, window.noReset = 1
        }), D.on("update_Area", function (g, e) {
            if (z.setExecuted(!0), D.trigger("clear_house_card"), "normal" == window.g_conf.model) {
                p(A(), e);
                var t = a(z.getZoom());
                if ("community" != t) {
                    var n = z.getMap();
                    if (S && n.removeOverlay(S), window.g_conf.currentResblockLabel) {
                        var i = window.g_conf.currentResblockLabel;
                        S = new BMap.Label('<div class="resblock_label" data-position="' + i.lng + "," + i.lat + '"></div>', {
                            position: new BMap.Point(i.lng, i.lat),
                            offset: new BMap.Size(-20, -50)
                        }), S.setStyle({
                            border: "none",
                            "z-index": 3,
                            "background-color": "transparent"
                        }), S.setZIndex(1e7), z.getMap().addOverlay(S)
                    }
                }
                z.isClickEvent && (z.isClickEvent = !1)
            } else if ("ditie" == window.g_conf.model && window.g_conf.startDitie) {
                b(C(), e);
                var t = a(z.getZoom());
                if ("community" != t) {
                    var n = z.getMap();
                    if (S && n.removeOverlay(S), window.g_conf.currentResblockLabel) {
                        var i = window.g_conf.currentResblockLabel;
                        S = new BMap.Label('<div class="resblock_label" data-position="' + i.lng + "," + i.lat + '"></div>', {
                            position: new BMap.Point(i.lng, i.lat),
                            offset: new BMap.Size(-20, -50)
                        }), S.setStyle({
                            border: "none",
                            "z-index": 3,
                            "background-color": "transparent"
                        }), S.setZIndex(1e7), z.getMap().addOverlay(S)
                    }
                }
            } else "circle" == window.g_conf.model && p(I(), e);
            D.trigger("clear_resblock_card")
        }), D.on("remove_resblock_label", function () {
            var g = z.getMap();
            S && g.removeOverlay(S), window.g_conf.currentResblockLabel = null
        }), D.on("move_Area", function (g, A) {
            z.getZoom();
            "ditie" == window.g_conf.model ? (z.centerAndZoom(A.longitude, A.latitude, 14), M = 1) : "circle" == window.g_conf.model && (z.centerAndZoom(A.longitude, A.latitude, A.zoom), M = 1)
        }), D.on("removeHint", function () {
            m()
        }), D.on("create_white_bubble", function (g, A) {
            Z.clearAll(), h(A)
        }), D.on("fetch_resblock_card", function (g, A) {
            var C = A;
            R.getResblockCard(A, function (g) {
                g.data.lat = C.lat, g.data.lng = C.lng, d(g)
            })
        }), D.on("clear_resblock_card", function () {
            W.removeHouseCard()
        }), D.on("click_Area", function (g, A) {
            var C = z.getZoom();
            if (A.restore_zoom && (C = A.restore_zoom), z.isClickEvent = !0, "ditie" == window.g_conf.model) H = [A], A.ditieInfo = V.getParam(), s(H), z.isClickEvent = !1, window.noReset = 1, z.centerAndZoom(A.longitude, A.latitude, 16), D.trigger("save_state", A), D.trigger("show_schedule", A); else if ("circle" == window.g_conf.model) H = [A], A.circleInfo = G.getState(), s(H), z.isClickEvent = !1, window.noReset = 1, z.centerAndZoom(A.longitude, A.latitude, 16), D.trigger("save_state", A); else {
                var I = a(C);
                "district" == I ? (z.centerAndZoom(A.longitude, A.latitude, o(C)), M = 1, D.trigger("clear_resblock_card")) : "bizcircle" == I ? (H = [A], M = 1, z.centerAndZoom(A.longitude, A.latitude, o(C)), D.trigger("clear_resblock_card"), D.trigger("clearStationInfo")) : (H = [A], window.g_conf.bubbleData = H, A.renderHouse && s(H), z.isClickEvent = !1, window.noReset = 1, z.centerAndZoom(A.longitude, A.latitude, o(C)))
            }
        }), D.on("update_house_add_Area", function (g, A) {
            s(H, A.offset, 0, A.order)
        })
    }

    function y(g) {
        x = g.map, M = 1, w()
    }

    var x, k, S, M, T, L, B, P, O = require("mapV2/js/model"), D = require("mapV2/js/msg"),
        Z = require("mapV2/js/bubble"), W = require("mapV2/js/house"), z = require("mapV2/js/mapView"),
        V = require("mapV2/js/ditie"), G = require("mapV2/js/circle"), N = !1, H = [], Y = [], R = new O, E = [];
    return R.init = y, R
}), define("mapV2/js/tips", function (require, g) {
    function A(g, A) {
        return "可视范围内" + (g || 0) + "套房源，共" + (A || 0) + "套"
    }

    function C() {
        I = $("<div class='tips'></div>"), I.insertAfter($("#filter")), t.on("showTips", function (g, C) {
            e && clearTimeout(e), I.html(A(C.visible_count, C.total_count)), I.addClass("active"), e = setTimeout(function () {
                I.removeClass("active")
            }, 3e3)
        })
    }

    var I, e, t = require("mapV2/js/msg");
    $("#" + g_conf.mapWrapper);
    return {init: C}
}), define("mapV2/js/state", function (require, g) {
    function A() {
        try {
            if ((C = window.localStorage.getItem("dituzhaofang_state")) && "{}" != C && "#turnToHouse" == location.hash) {
                if (C = JSON.parse(C), I = C, "ditie" == C.model) {
                    var g = C.data.ditieInfo;
                    e.trigger("move_station", {
                        line_id: g.line_id, station_id: g.station_id, callback: function () {
                            e.trigger("click_Area", C.data)
                        }
                    })
                } else if ("circle" == C.model) {
                    var A = C.data.circleInfo;
                    e.trigger("move_circle", {
                        pointArray: A.pointArray, callback: function () {
                            e.trigger("click_Area", C.data)
                        }
                    })
                } else e.trigger("click_Area", C.data);
                setTimeout(function () {
                    if ($els = $(".bubble-3"), !$els.length) return void setTimeout(arguments.callee, 100);
                    $(".bubble-3").each(function (g, A) {
                        $(A).data("id") == C.data.id && e.trigger("bubble_click_style", $(A))
                    }), window.localStorage.setItem("dituzhaofang_state", "")
                }, 500)
            }
        } catch (g) {
        }
        e.on("save_state", function (g, A) {
            I = {}, I.model = window.g_conf.model, A.restore_zoom = A.restore_zoom || 16, A.renderHouse = !0, I.data = A
        }), e.on("confirm_save", function (g, A) {
            try {
                window.localStorage.setItem("dituzhaofang_state", JSON.stringify(I)), "#turnToHouse" != location.hash && location.replace(location.href + "#turnToHouse"), I = {}
            } catch (g) {
            }
        })
    }

    var C, I, e = require("mapV2/js/msg");
    return {init: A}
}), define("mapV2/js/map", function (require, g) {
    return $("html").css("font-size", "16px"), g.init = function () {
        var g = require("mapV2/js/mapView"), A = require("mapV2/js/search"),
            C = (require("mapV2/js/ctl"), require("mapV2/js/area"));
        if (window.ljConf && window.ljConf.hasDitie && "false" != window.ljConf.hasDitie) {
            var I = require("mapV2/js/ditie");
            g.addCb(I.init), $(".subwayFilter").show()
        }
        var e = require("mapV2/js/circle"), t = require("mapV2/js/house"), n = require("mapV2/js/filter"),
            a = require("mapV2/js/bubble"), i = require("mapV2/js/tips"), o = require("mapV2/js/state");
        A.init(), g.addCb(e.init), g.addCb(C.init), g.addCb(n.init), g.addCb(t.init), g.addCb(a.init), g.addCb(i.init), g.addCb(o.init), g.init()
    }, g
});