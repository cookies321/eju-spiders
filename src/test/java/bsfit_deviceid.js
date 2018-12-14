(function () {
    function La() {
        if (-1 == G("BSFIT_EXPIRATION")) for (var a = 0; 10 > a; a++) setTimeout(function () {
            (new ea).getFingerPrint()
        }, 20 + 2E3 * Math.pow(a, 2)); else (new ea).getFingerPrint();
        setTimeout(function () {
            window.setInterval(function () {
                (new ea).getFingerPrint()
            }, 3E5)
        }, 3E5)
    }

    function fb(a) {
        this.isTimeout = 0;
        var b = this, c = window.RTCPeerConnection || window.webkitRTCPeerConnection || window.mozRTCPeerConnection;
        if ("function" == typeof c) {
            try {
                var d = new c({iceServers: []});
                d.createDataChannel("", {reliable: !1})
            } catch (f) {
                if (2 !=
                    b.isTimeout) {
                    b.isTimeout = 1;
                    a();
                    return
                }
            }
            var e = !1;
            d.onicecandidate = function (c) {
                var d = /([0-9]{1,3}(\.[0-9]{1,3}){3})/, f = [];
                "complete" != c.target.iceGatheringState || e || (e = !0, c.target.localDescription.sdp.split("\n").forEach(function (a) {
                    (a = d.exec(a)) && "127.0.0.1" != a[1] && "0.0.0.0" != a[1] && -1 === f.indexOf(a[1]) && f.push(a[1])
                }), 2 != b.isTimeout && (b.isTimeout = 1, a({localAddr: 0 < f.length ? f.sort()[0] : ""})))
            };
            d.onaddstream = function (a) {
                remoteVideo.src = window.URL.createObjectURL(a.stream)
            };
            d.createOffer(function (a) {
                d.setLocalDescription(a,
                    function () {
                    }, function () {
                    })
            }, function () {
            }, {})
        } else a();
        setTimeout(function () {
            0 == b.isTimeout && (b.isTimeout = 2, a())
        }, 500)
    }

    function Ma(a) {
        for (var b = "", c = a.length - 1; 0 <= c; c--) b += a.charAt(c);
        return b
    }

    function Na(a) {
        return null != /[\\\"<>\.;]/.exec(a) && "undefined" != typeof encodeURIComponent ? encodeURIComponent(a) : a
    }

    function K(a, b) {
        if (Oa) {
            var c = b ? "visible" : "hidden";
            L && F(a) ? F(a).style.visibility = c : Pa("#" + a, "visibility:" + c)
        }
    }

    function Pa(a, b, c, d) {
        if (!n.ie || !n.mac) {
            var e = t.getElementsByTagName("head")[0];
            e && (c = c &&
            "string" == typeof c ? c : "screen", d && (ua = H = null), H && ua == c || (d = t.createElement("style"), d.setAttribute("type", "text/css"), d.setAttribute("media", c), H = e.appendChild(d), n.ie && n.win && "undefined" != typeof t.styleSheets && 0 < t.styleSheets.length && (H = t.styleSheets[t.styleSheets.length - 1]), ua = c), n.ie && n.win ? H && "object" == typeof H.addRule && H.addRule(a, b) : H && "undefined" != typeof t.createTextNode && H.appendChild(t.createTextNode(a + " {" + b + "}")))
        }
    }

    function fa(a) {
        var b = n.pv;
        a = a.split(".");
        a[0] = parseInt(a[0], 10);
        a[1] = parseInt(a[1],
            10) || 0;
        a[2] = parseInt(a[2], 10) || 0;
        return b[0] > a[0] || b[0] == a[0] && b[1] > a[1] || b[0] == a[0] && b[1] == a[1] && b[2] >= a[2] ? !0 : !1
    }

    function F(a) {
        var b = null;
        try {
            b = t.getElementById(a)
        } catch (c) {
        }
        return b
    }

    function Qa(a) {
        var b = F(a);
        b && "OBJECT" == b.nodeName && (n.ie && n.win ? (b.style.display = "none", function d() {
            if (4 == b.readyState) {
                var e = F(a);
                if (e) {
                    for (var f in e) "function" == typeof e[f] && (e[f] = null);
                    e.parentNode.removeChild(e)
                }
            } else setTimeout(d, 10)
        }()) : b.parentNode.removeChild(b))
    }

    function va(a, b, c) {
        var d, e = F(c);
        if (n.wk && 312 >
            n.wk) return d;
        if (e) if ("undefined" == typeof a.id && (a.id = c), n.ie && n.win) {
            var f = "", g;
            for (g in a) a[g] != Object.prototype[g] && ("data" == g.toLowerCase() ? b.movie = a[g] : "styleclass" == g.toLowerCase() ? f += ' class\x3d"' + a[g] + '"' : "classid" != g.toLowerCase() && (f += " " + g + '\x3d"' + a[g] + '"'));
            g = "";
            for (var k in b) b[k] != Object.prototype[k] && (g += '\x3cparam name\x3d"' + k + '" value\x3d"' + b[k] + '" /\x3e');
            e.outerHTML = '\x3cobject classid\x3d"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"' + f + "\x3e" + g + "\x3c/object\x3e";
            ga[ga.length] = a.id;
            d = F(a.id)
        } else {
            k = t.createElement("object");
            k.setAttribute("type", "application/x-shockwave-flash");
            for (var q in a) a[q] != Object.prototype[q] && ("styleclass" == q.toLowerCase() ? k.setAttribute("class", a[q]) : "classid" != q.toLowerCase() && k.setAttribute(q, a[q]));
            for (f in b) b[f] != Object.prototype[f] && "movie" != f.toLowerCase() && (a = k, g = f, q = b[f], c = t.createElement("param"), c.setAttribute("name", g), c.setAttribute("value", q), a.appendChild(c));
            e.parentNode.replaceChild(k, e);
            d = k
        }
        return d
    }

    function wa(a) {
        var b = t.createElement("div");
        if (n.win && n.ie) b.innerHTML = a.innerHTML; else if (a = a.getElementsByTagName("object")[0]) if (a = a.childNodes) for (var c = a.length, d = 0; d < c; d++) 1 == a[d].nodeType && "PARAM" == a[d].nodeName || 8 == a[d].nodeType || b.appendChild(a[d].cloneNode(!0));
        return b
    }

    function gb(a) {
        if (n.ie && n.win && 4 != a.readyState) {
            var b = t.createElement("div");
            a.parentNode.insertBefore(b, a);
            b.parentNode.replaceChild(wa(a), b);
            a.style.display = "none";
            (function d() {
                4 == a.readyState ? a.parentNode.removeChild(a) : setTimeout(d, 10)
            })()
        } else a.parentNode.replaceChild(wa(a),
            a)
    }

    function xa(a, b, c, d) {
        ha = !0;
        ya = d || null;
        Ra = {success: !1, id: c};
        var e = F(c);
        if (e) {
            "OBJECT" == e.nodeName ? (U = wa(e), ia = null) : (U = e, ia = c);
            a.id = "SWFObjectExprInst";
            if ("undefined" == typeof a.width || !/%$/.test(a.width) && 310 > parseInt(a.width, 10)) a.width = "310";
            if ("undefined" == typeof a.height || !/%$/.test(a.height) && 137 > parseInt(a.height, 10)) a.height = "137";
            t.title = t.title.slice(0, 47) + " - Flash Player Installation";
            d = n.ie && n.win ? "ActiveX" : "PlugIn";
            d = "MMredirectURL\x3d" + E.location.toString().replace(/&/g, "%26") + "\x26MMplayerType\x3d" +
                d + "\x26MMdoctitle\x3d" + t.title;
            b.flashvars = "undefined" != typeof b.flashvars ? b.flashvars + ("\x26" + d) : d;
            n.ie && n.win && 4 != e.readyState && (d = t.createElement("div"), c += "SWFObjectNew", d.setAttribute("id", c), e.parentNode.insertBefore(d, e), e.style.display = "none", function g() {
                4 == e.readyState ? e.parentNode.removeChild(e) : setTimeout(g, 10)
            }());
            va(a, b, c)
        }
    }

    function za() {
        return !ha && fa("6.0.65") && (n.win || n.mac) && !(n.wk && 312 > n.wk)
    }

    function Aa(a) {
        var b = null;
        (a = F(a)) && "OBJECT" == a.nodeName && ("undefined" != typeof a.SetVariable ?
            b = a : (a = a.getElementsByTagName("object")[0]) && (b = a));
        return b
    }

    function Ba() {
        var a = I.length;
        if (0 < a) for (var b = 0; b < a; b++) {
            var c = I[b].id, d = I[b].callbackFn, e = {success: !1, id: c};
            if (0 < n.pv[0]) {
                var f = F(c);
                if (f) if (!fa(I[b].swfVersion) || n.wk && 312 > n.wk) if (I[b].expressInstall && za()) {
                    e = {};
                    e.data = I[b].expressInstall;
                    e.width = f.getAttribute("width") || "0";
                    e.height = f.getAttribute("height") || "0";
                    f.getAttribute("class") && (e.styleclass = f.getAttribute("class"));
                    f.getAttribute("align") && (e.align = f.getAttribute("align"));
                    for (var g = {}, f = f.getElementsByTagName("param"), k = f.length, q = 0; q < k; q++) "movie" != f[q].getAttribute("name").toLowerCase() && (g[f[q].getAttribute("name")] = f[q].getAttribute("value"));
                    xa(e, g, c, d)
                } else gb(f), d && d(e); else K(c, !0), d && (e.success = !0, e.ref = Aa(c), d(e))
            } else K(c, !0), d && ((c = Aa(c)) && "undefined" != typeof c.SetVariable && (e.success = !0, e.ref = c), d(e))
        }
    }

    function Sa(a) {
        if ("undefined" != typeof E.addEventListener) E.addEventListener("load", a, !1); else if ("undefined" != typeof t.addEventListener) t.addEventListener("load",
            a, !1); else if ("undefined" != typeof E.attachEvent) {
            var b = E;
            b.attachEvent("onload", a);
            O[O.length] = [b, "onload", a]
        } else if ("function" == typeof E.onload) {
            var c = E.onload;
            E.onload = function () {
                c();
                a()
            }
        } else E.onload = a
    }

    function Ta(a) {
        L ? a() : ja[ja.length] = a
    }

    function P() {
        if (!L) {
            try {
                var a = t.getElementsByTagName("body")[0].appendChild(t.createElement("span"));
                a.parentNode.removeChild(a)
            } catch (c) {
                return
            }
            L = !0;
            for (var a = ja.length, b = 0; b < a; b++) ja[b]()
        }
    }

    function Ca(a) {
        if (!a) return "";
        if (hb(a)) return a.replace(/\s/g, "");
        -1 != a.indexOf("://") && (a = a.substr(a.indexOf("://") + 3));
        var b = "com net org gov edu mil biz name info mobi pro travel museum int areo post rec".split(" "),
            c = a.split(".");
        if (1 >= c.length || !isNaN(c[c.length - 1])) return a;
        for (a = 0; a < b.length && b[a] != c[c.length - 1];) a++;
        if (a != b.length) return "." + c[c.length - 2] + "." + c[c.length - 1];
        for (a = 0; a < b.length && b[a] != c[c.length - 2];) a++;
        return a == b.length ? c[c.length - 2] + "." + c[c.length - 1] : "." + c[c.length - 3] + "." + c[c.length - 2] + "." + c[c.length - 1]
    }

    function Ua(a) {
        return 4294967296 * (a -
            (a | 0)) | 0
    }

    function ib(a) {
        var b = a.split(".");
        if (4 !== b.length) throw Error("Invalid format -- expecting a.b.c.d");
        for (var c = a = 0; c < b.length; ++c) {
            var d = parseInt(b[c], 10);
            if (Number.isNaN(d) || 0 > d || 255 < d) throw Error("Each octet must be between 0 and 255");
            a |= d << 8 * (b.length - c - 1);
            a >>>= 0
        }
        return a
    }

    function V(a) {
        if (!(this instanceof V)) return new V(a);
        this.options = this.extend(a, {
            swfContainerId: "fingerprintjs2",
            swfPath: "flash/compiled/FontList.swf",
            detectScreenOrientation: !0,
            sortPluginsFor: [/palemoon/i],
            userDefinedFonts: []
        });
        this.nativeForEach = Array.prototype.forEach;
        this.nativeMap = Array.prototype.map
    }

    function W(a) {
        for (var b = [], c = 0; c < 8 * a.length; c += 8) b[c >> 5] |= (a.charCodeAt(c / 8) & 255) << c % 32;
        a = 8 * a.length;
        b[a >> 5] |= 128 << a % 32;
        b[(a + 64 >>> 9 << 4) + 14] = a;
        a = 1732584193;
        for (var c = -271733879, d = -1732584194, e = 271733878, f = 0; f < b.length; f += 16) {
            var g = a, k = c, q = d, l = e;
            a = y(a, c, d, e, b[f + 0], 7, -680876936);
            e = y(e, a, c, d, b[f + 1], 12, -389564586);
            d = y(d, e, a, c, b[f + 2], 17, 606105819);
            c = y(c, d, e, a, b[f + 3], 22, -1044525330);
            a = y(a, c, d, e, b[f + 4], 7, -176418897);
            e = y(e, a, c, d,
                b[f + 5], 12, 1200080426);
            d = y(d, e, a, c, b[f + 6], 17, -1473231341);
            c = y(c, d, e, a, b[f + 7], 22, -45705983);
            a = y(a, c, d, e, b[f + 8], 7, 1770035416);
            e = y(e, a, c, d, b[f + 9], 12, -1958414417);
            d = y(d, e, a, c, b[f + 10], 17, -42063);
            c = y(c, d, e, a, b[f + 11], 22, -1990404162);
            a = y(a, c, d, e, b[f + 12], 7, 1804603682);
            e = y(e, a, c, d, b[f + 13], 12, -40341101);
            d = y(d, e, a, c, b[f + 14], 17, -1502002290);
            c = y(c, d, e, a, b[f + 15], 22, 1236535329);
            a = z(a, c, d, e, b[f + 1], 5, -165796510);
            e = z(e, a, c, d, b[f + 6], 9, -1069501632);
            d = z(d, e, a, c, b[f + 11], 14, 643717713);
            c = z(c, d, e, a, b[f + 0], 20, -373897302);
            a =
                z(a, c, d, e, b[f + 5], 5, -701558691);
            e = z(e, a, c, d, b[f + 10], 9, 38016083);
            d = z(d, e, a, c, b[f + 15], 14, -660478335);
            c = z(c, d, e, a, b[f + 4], 20, -405537848);
            a = z(a, c, d, e, b[f + 9], 5, 568446438);
            e = z(e, a, c, d, b[f + 14], 9, -1019803690);
            d = z(d, e, a, c, b[f + 3], 14, -187363961);
            c = z(c, d, e, a, b[f + 8], 20, 1163531501);
            a = z(a, c, d, e, b[f + 13], 5, -1444681467);
            e = z(e, a, c, d, b[f + 2], 9, -51403784);
            d = z(d, e, a, c, b[f + 7], 14, 1735328473);
            c = z(c, d, e, a, b[f + 12], 20, -1926607734);
            a = A(a, c, d, e, b[f + 5], 4, -378558);
            e = A(e, a, c, d, b[f + 8], 11, -2022574463);
            d = A(d, e, a, c, b[f + 11], 16, 1839030562);
            c = A(c, d, e, a, b[f + 14], 23, -35309556);
            a = A(a, c, d, e, b[f + 1], 4, -1530992060);
            e = A(e, a, c, d, b[f + 4], 11, 1272893353);
            d = A(d, e, a, c, b[f + 7], 16, -155497632);
            c = A(c, d, e, a, b[f + 10], 23, -1094730640);
            a = A(a, c, d, e, b[f + 13], 4, 681279174);
            e = A(e, a, c, d, b[f + 0], 11, -358537222);
            d = A(d, e, a, c, b[f + 3], 16, -722521979);
            c = A(c, d, e, a, b[f + 6], 23, 76029189);
            a = A(a, c, d, e, b[f + 9], 4, -640364487);
            e = A(e, a, c, d, b[f + 12], 11, -421815835);
            d = A(d, e, a, c, b[f + 15], 16, 530742520);
            c = A(c, d, e, a, b[f + 2], 23, -995338651);
            a = B(a, c, d, e, b[f + 0], 6, -198630844);
            e = B(e, a, c, d, b[f + 7], 10, 1126891415);
            d = B(d, e, a, c, b[f + 14], 15, -1416354905);
            c = B(c, d, e, a, b[f + 5], 21, -57434055);
            a = B(a, c, d, e, b[f + 12], 6, 1700485571);
            e = B(e, a, c, d, b[f + 3], 10, -1894986606);
            d = B(d, e, a, c, b[f + 10], 15, -1051523);
            c = B(c, d, e, a, b[f + 1], 21, -2054922799);
            a = B(a, c, d, e, b[f + 8], 6, 1873313359);
            e = B(e, a, c, d, b[f + 15], 10, -30611744);
            d = B(d, e, a, c, b[f + 6], 15, -1560198380);
            c = B(c, d, e, a, b[f + 13], 21, 1309151649);
            a = B(a, c, d, e, b[f + 4], 6, -145523070);
            e = B(e, a, c, d, b[f + 11], 10, -1120210379);
            d = B(d, e, a, c, b[f + 2], 15, 718787259);
            c = B(c, d, e, a, b[f + 9], 21, -343485551);
            a = x(a, g);
            c = x(c, k);
            d = x(d,
                q);
            e = x(e, l)
        }
        b = [a, c, d, e];
        a = "";
        for (c = 0; c < 4 * b.length; c++) a += "0123456789abcdef".charAt(b[c >> 2] >> c % 4 * 8 + 4 & 15) + "0123456789abcdef".charAt(b[c >> 2] >> c % 4 * 8 & 15);
        return a
    }

    function y(a, b, c, d, e, f, g) {
        return x(ka(x(x(a, b & c | ~b & d), x(e, g)), f), b)
    }

    function z(a, b, c, d, e, f, g) {
        return x(ka(x(x(a, b & d | c & ~d), x(e, g)), f), b)
    }

    function A(a, b, c, d, e, f, g) {
        return x(ka(x(x(a, b ^ c ^ d), x(e, g)), f), b)
    }

    function B(a, b, c, d, e, f, g) {
        return x(ka(x(x(a, c ^ (b | ~d)), x(e, g)), f), b)
    }

    function x(a, b) {
        var c = (a & 65535) + (b & 65535);
        return (a >> 16) + (b >> 16) + (c >> 16) << 16 |
            c & 65535
    }

    function ka(a, b) {
        return a << b | a >>> 32 - b
    }

    function G(a) {
        var b, c, d, e = document.cookie.split(";");
        for (b = 0; b < e.length; b++) if (c = e[b].substr(0, e[b].indexOf("\x3d")), d = e[b].substr(e[b].indexOf("\x3d") + 1), c = c.replace(/^\s+|\s+$/g, ""), a = a.replace(/^\s+|\s+$/g, ""), c == a) return unescape(d)
    }

    function Q(a, b, c, d, e, f) {
        var g = new Date;
        g.setTime(g.getTime());
        -1 != c ? (c *= 864E5, g = new Date(g.getTime() + c),
            cookieString = a + "\x3d" + escape(b) + (c ? ";expires\x3d" + g.toGMTString() : "") + (d ? ";path\x3d" + d : "") + (e ? ";domain\x3d" + e : "") +
            (f ? ";secure" : "")) : (g = -1, cookieString = a + "\x3d" + escape(b) + (c ? ";expires\x3d" + g : "") + (d ? ";path\x3d" + d : "") + (e ? ";domain\x3d" + e : "") + (f ? ";secure" : ""));
        document.cookie = cookieString
    }

    function hb(a) {
        a = a.replace(/\s/g, "");
        if (/^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/.test(a)) {
            a = a.split(".");
            if (0 == parseInt(parseFloat(a[0])) || 0 == parseInt(parseFloat(a[3]))) return !1;
            for (var b = 0; b < a.length; b++) if (255 < parseInt(parseFloat(a[b]))) return !1;
            return !0
        }
        return !1
    }

    function m(a, b) {
        this.key = a;
        this.value = b
    }

    function Q(a, b, c) {
        var d = new Date;
        d.setTime(d.getTime() + 864E5 * Number(c));
        c = Ca(window.location.host);
        document.cookie = a + "\x3d" + b + "; path\x3d/;expires \x3d " + d.toGMTString() + (c ? ";domain\x3d" + c.split(":")[0] : "")
    }

    function Da() {
        return "ontouchstart" in window || 0 < navigator.maxTouchPoints || 0 < navigator.msMaxTouchPoints ? "WAP" : "WEB"
    }

    function Da() {
        return "ontouchstart" in window || 0 < navigator.maxTouchPoints || 0 < navigator.msMaxTouchPoints ? "WAP" : "WEB"
    }

    function ea() {
        this.ec = new evercookie;
        this.deviceEc = new evercookie;
        this.expTimeEc = new evercookie;
        this.verEc =
            new evercookie;
        this.cfp = new V;
        this.packageString = "";
        this.moreInfoArray = []
    }

    var Va = {
        now: function () {
            return (new Date).getTime()
        }, rand: function () {
            return Math.random().toString().substr(2)
        }, removeElem: function (a) {
            var b = a.parentNode;
            if (b) try {
                b.removeChild(a)
            } catch (c) {
            }
        }, parseData: function (a) {
            var b = "";
            if ("string" === typeof a) b = a; else if ("object" === typeof a) for (var c in a) b += "\x26" + c + "\x3d" + encodeURIComponent(a[c]);
            b += "\x26_time\x3d" + this.now();
            return b = b.substr(1)
        }, getJSON: function (a, b, c) {
            b = document.createElement("script");
            b.type = "text/javascript";
            b.src = a;
            b.id = "id_callbackFunction";
            window.callbackFunction = function (a) {
                window.callbackFunction = void 0;
                var b = document.getElementById("id_callbackFunction");
                b && Va.removeElem(b);
                c(a)
            };
            (a = document.getElementsByTagName("head")) && a[0] && a[0].appendChild(b)
        }
    };
    "object" != typeof JSON && (JSON = {});
    (function () {
        function a(a) {
            return 10 > a ? "0" + a : a
        }

        function b() {
            return this.valueOf()
        }

        function c(a) {
            return p.lastIndex = 0, p.test(a) ? '"' + a.replace(p, function (a) {
                var b = g[a];
                return "string" == typeof b ? b :
                    "\\u" + ("0000" + a.charCodeAt(0).toString(16)).slice(-4)
            }) + '"' : '"' + a + '"'
        }

        function d(a, b) {
            var g, r, p, u, w, l = e, h = b[a];
            switch (h && "object" == typeof h && "function" == typeof h.toJSON && (h = h.toJSON(a)), "function" == typeof k && (h = k.call(b, a, h)), typeof h) {
                case "string":
                    return c(h);
                case "number":
                    return isFinite(h) ? String(h) : "null";
                case "boolean":
                case "null":
                    return String(h);
                case "object":
                    if (!h) return "null";
                    if (e += f, w = [], "[object Array]" === Object.prototype.toString.apply(h)) {
                        u = h.length;
                        for (g = 0; u > g; g += 1) w[g] = d(g, h) || "null";
                        return p = 0 === w.length ? "[]" : e ? "[\n" + e + w.join(",\n" + e) + "\n" + l + "]" : "[" + w.join(",") + "]", e = l, p
                    }
                    if (k && "object" == typeof k) for (u = k.length, g = 0; u > g; g += 1) "string" == typeof k[g] && (r = k[g], p = d(r, h), p && w.push(c(r) + (e ? ": " : ":") + p)); else for (r in h) Object.prototype.hasOwnProperty.call(h, r) && (p = d(r, h), p && w.push(c(r) + (e ? ": " : ":") + p));
                    return p = 0 === w.length ? "{}" : e ? "{\n" + e + w.join(",\n" + e) + "\n" + l + "}" : "{" + w.join(",") + "}", e = l, p
            }
        }

        var e, f, g, k, q = /^[\],:{}\s]*$/, l = /\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,
            h = /"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,
            r = /(?:^|:|,)(?:\s*\[)+/g,
            p = /[\\\"\u0000-\u001f\u007f-\u009f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
            u = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g;
        "function" != typeof Date.prototype.toJSON && (Date.prototype.toJSON = function () {
            return isFinite(this.valueOf()) ? this.getUTCFullYear() + "-" + a(this.getUTCMonth() + 1) + "-" + a(this.getUTCDate()) + "T" + a(this.getUTCHours()) + ":" + a(this.getUTCMinutes()) +
                ":" + a(this.getUTCSeconds()) + "Z" : null
        }, Boolean.prototype.toJSON = b, Number.prototype.toJSON = b, String.prototype.toJSON = b);
        "function" != typeof JSON.stringify && (g = {
            "\b": "\\b",
            "   ": "\\t",
            "\n": "\\n",
            "\f": "\\f",
            "\r": "\\r",
            '"': '\\"',
            "\\": "\\\\"
        }, JSON.stringify = function (a, b, c) {
            var g;
            if (e = "", f = "", "number" == typeof c) for (g = 0; c > g; g += 1) f += " "; else "string" == typeof c && (f = c);
            if (k = b, b && "function" != typeof b && ("object" != typeof b || "number" != typeof b.length)) throw Error("JSON.stringify");
            return d("", {"": a})
        });
        "function" !=
        typeof JSON.parse && (JSON.parse = function (a, b) {
            function c(a, d) {
                var e, f, g = a[d];
                if (g && "object" == typeof g) for (e in g) Object.prototype.hasOwnProperty.call(g, e) && (f = c(g, e), void 0 !== f ? g[e] = f : delete g[e]);
                return b.call(a, d, g)
            }

            var d;
            if (a = String(a), u.lastIndex = 0, u.test(a) && (a = a.replace(u, function (a) {
                    return "\\u" + ("0000" + a.charCodeAt(0).toString(16)).slice(-4)
                })), q.test(a.replace(l, "@").replace(h, "]").replace(r, ""))) return d = eval("(" + a + ")"), "function" == typeof b ? c({"": d}, "") : d;
            throw new SyntaxError("JSON.parse");
        })
    })();
    Array.prototype.indexOf || (Array.prototype.indexOf = function (a, b) {
        var c;
        if (null == this) throw new TypeError("'this' is null or undefined");
        var d = Object(this), e = d.length >>> 0;
        if (0 === e) return -1;
        c = +b || 0;
        Infinity === Math.abs(c) && (c = 0);
        if (c >= e) return -1;
        for (c = Math.max(0 <= c ? c : e - Math.abs(c), 0); c < e;) {
            if (c in d && d[c] === a) return c;
            c++
        }
        return -1
    });
    V.prototype = {
        extend: function (a, b) {
            if (null == a) return b;
            for (var c in a) null != a[c] && b[c] !== a[c] && (b[c] = a[c]);
            return b
        }, get: function (a) {
            var b = [], c = [], d = {
                Linux: "color_depth pixel_ratio timezone_offset cpu_class navigator_platform touch_support js_fonts open_database webgl_vendor".split(" "),
                Win32: "color_depth resolution timezone_offset navigator_platform webgl_vendor touch_support".split(" "),
                Win64: "color_depth resolution timezone_offset navigator_platform webgl_vendor touch_support".split(" "),
                MacIntel: "color_depth resolution pixel_ratio timezone_offset navigator_platform touch_support".split(" "),
                iPhone: "canvas color_depth timezone_offset cpu_class navigator_platform touch_support resolution pixel_ratio js_fonts webgl webgl_vendor".split(" ")
            };
            /Linux|linux/g.test(navigator.platform) &&
            (c = d.Linux);
            navigator.platform && d[navigator.platform] && (c = d[navigator.platform]);
            var b = this.languageKey(b), b = this.colorDepthKey(b), b = this.pixelRatioKey(b),
                b = this.screenResolutionKey(b), b = this.availableScreenResolutionKey(b),
                b = this.timezoneOffsetKey(b), b = this.cpuClassKey(b), b = this.platformKey(b), b = this.canvasKey(b),
                b = this.touchSupportKey(b), b = this.userAgentKey(b), b = this.sessionStorageKey(b),
                b = this.localStorageKey(b), b = this.indexedDbKey(b), b = this.addBehaviorKey(b),
                b = this.openDatabaseKey(b), b = this.doNotTrackKey(b),
                b = this.pluginsKey(b), b = this.webglKey(b), b = this.webglVendorAndRendererKey(b),
                b = this.adBlockKey(b), b = this.hasLiedLanguagesKey(b), b = this.hasLiedResolutionKey(b),
                b = this.hasLiedOsKey(b), b = this.hasLiedBrowserKey(b), e = this;
            this.fontsKey(b, function (b) {
                var d = [], f = [];
                e.each(b, function (a) {
                    var b = a.value;
                    null != b && (a.value && "function" == typeof a.value.join && (b = a.value.join(";")), -1 != c.indexOf(a.key) ? ("touch_support" == a.key && (b = a.value[0]), "webgl_vendor" != a.key || "Win32" != navigator.platform && "Win64" != navigator.platform ||
                    null == b || (a = b.match(/Graphics \w+/), null != a && 0 < a.length && (b = b.match(/Graphics \w+/)[0])), f.push(b)) : d.push(b))
                });
                var q = e.x64hash128(f.join("~~~~"), 31).substring(16, 32) + e.x64hash128(d.join("~~~"), 31).substring(16, 32);
                return a(q, b)
            })
        }, userAgentKey: function (a) {
            this.options.excludeUserAgent || a.push({key: "user_agent", value: this.getUserAgent()});
            return a
        }, getUserAgent: function () {
            var a = navigator.userAgent;
            return a = a.replace(/\&|\+|\?|\%|\#|\/|\=/g, "")
        }, languageKey: function (a) {
            this.options.excludeLanguage ||
            a.push({
                key: "language",
                value: navigator.language || navigator.userLanguage || navigator.browserLanguage || navigator.systemLanguage || ""
            });
            return a
        }, colorDepthKey: function (a) {
            this.options.excludeColorDepth || a.push({key: "color_depth", value: screen.colorDepth || -1});
            return a
        }, pixelRatioKey: function (a) {
            this.options.excludePixelRatio || a.push({key: "pixel_ratio", value: this.getPixelRatio()});
            return a
        }, getPixelRatio: function () {
            return window.devicePixelRatio || ""
        }, screenResolutionKey: function (a) {
            return this.options.excludeScreenResolution ?
                a : this.getScreenResolution(a)
        }, getScreenResolution: function (a) {
            var b;
            b = this.options.detectScreenOrientation ? screen.height > screen.width ? [screen.height, screen.width] : [screen.width, screen.height] : [screen.width, screen.height];
            "undefined" !== typeof b && a.push({key: "resolution", value: b});
            return a
        }, availableScreenResolutionKey: function (a) {
            return this.options.excludeAvailableScreenResolution ? a : this.getAvailableScreenResolution(a)
        }, getAvailableScreenResolution: function (a) {
            var b;
            screen.availWidth && screen.availHeight &&
            (b = this.options.detectScreenOrientation ? screen.availHeight > screen.availWidth ? [screen.availHeight, screen.availWidth] : [screen.availWidth, screen.availHeight] : [screen.availHeight, screen.availWidth]);
            "undefined" !== typeof b && a.push({key: "available_resolution", value: b});
            return a
        }, timezoneOffsetKey: function (a) {
            this.options.excludeTimezoneOffset || a.push({
                key: "timezone_offset",
                value: (new Date).getTimezoneOffset()
            });
            return a
        }, sessionStorageKey: function (a) {
            !this.options.excludeSessionStorage && this.hasSessionStorage() &&
            a.push({key: "session_storage", value: 1});
            return a
        }, localStorageKey: function (a) {
            !this.options.excludeSessionStorage && this.hasLocalStorage() && a.push({key: "local_storage", value: 1});
            return a
        }, indexedDbKey: function (a) {
            !this.options.excludeIndexedDB && this.hasIndexedDB() && a.push({key: "indexed_db", value: 1});
            return a
        }, addBehaviorKey: function (a) {
            document.body && !this.options.excludeAddBehavior && document.body.addBehavior && a.push({
                key: "add_behavior",
                value: 1
            });
            return a
        }, openDatabaseKey: function (a) {
            !this.options.excludeOpenDatabase &&
            window.openDatabase && a.push({key: "open_database", value: 1});
            return a
        }, cpuClassKey: function (a) {
            this.options.excludeCpuClass || a.push({key: "cpu_class", value: this.getNavigatorCpuClass()});
            return a
        }, platformKey: function (a) {
            this.options.excludePlatform || a.push({key: "navigator_platform", value: this.getNavigatorPlatform()});
            return a
        }, doNotTrackKey: function (a) {
            this.options.excludeDoNotTrack || a.push({key: "do_not_track", value: this.getDoNotTrack()});
            return a
        }, canvasKey: function (a) {
            !this.options.excludeCanvas &&
            this.isCanvasSupported() && a.push({key: "canvas", value: this.getCanvasFp()});
            return a
        }, webglKey: function (a) {
            if (this.options.excludeWebGL || !this.isWebGlSupported()) return a;
            a.push({key: "webgl", value: this.getWebglFp()});
            return a
        }, webglVendorAndRendererKey: function (a) {
            !this.options.excludeWebGLVendorAndRenderer && this.isWebGlSupported() && a.push({
                key: "webgl_vendor",
                value: this.getWebglVendorAndRenderer()
            });
            return a
        }, adBlockKey: function (a) {
            this.options.excludeAdBlock || a.push({key: "adblock", value: this.getAdBlock()});
            return a
        }, hasLiedLanguagesKey: function (a) {
            this.options.excludeHasLiedLanguages || a.push({
                key: "has_lied_languages",
                value: this.getHasLiedLanguages()
            });
            return a
        }, hasLiedResolutionKey: function (a) {
            this.options.excludeHasLiedResolution || a.push({
                key: "has_lied_resolution",
                value: this.getHasLiedResolution()
            });
            return a
        }, hasLiedOsKey: function (a) {
            this.options.excludeHasLiedOs || a.push({key: "has_lied_os", value: this.getHasLiedOs()});
            return a
        }, hasLiedBrowserKey: function (a) {
            this.options.excludeHasLiedBrowser || a.push({
                key: "has_lied_browser",
                value: this.getHasLiedBrowser()
            });
            return a
        }, fontsKey: function (a, b) {
            return this.options.excludeJsFonts ? this.flashFontsKey(a, b) : this.jsFontsKey(a, b)
        }, flashFontsKey: function (a, b) {
            if (this.options.excludeFlashFonts || !this.hasSwfObjectLoaded() || !this.hasMinFlashInstalled() || "undefined" === typeof this.options.swfPath) return b(a);
            this.loadSwfAndDetectFonts(function (c) {
                a.push({key: "swf_fonts", value: c.join(";")});
                b(a)
            })
        }, jsFontsKey: function (a, b) {
            var c = this;
            return setTimeout(function () {
                function d() {
                    var a = document.createElement("span");
                    a.style.position = "absolute";
                    a.style.left = "-9999px";
                    a.style.fontSize = "72px";
                    a.style.lineHeight = "normal";
                    a.innerHTML = "mmmmmmmmmmlli";
                    return a
                }

                var e = ["monospace", "sans-serif", "serif"],
                    f = "Andale Mono;Arial;Arial Black;Arial Hebrew;Arial MT;Arial Narrow;Arial Rounded MT Bold;Arial Unicode MS;Bitstream Vera Sans Mono;Book Antiqua;Bookman Old Style;Calibri;Cambria;Cambria Math;Century;Century Gothic;Century Schoolbook;Comic Sans;Comic Sans MS;Consolas;Courier;Courier New;Garamond;Geneva;Georgia;Helvetica;Helvetica Neue;Impact;Lucida Bright;Lucida Calligraphy;Lucida Console;Lucida Fax;LUCIDA GRANDE;Lucida Handwriting;Lucida Sans;Lucida Sans Typewriter;Lucida Sans Unicode;Microsoft Sans Serif;Monaco;Monotype Corsiva;MS Gothic;MS Outlook;MS PGothic;MS Reference Sans Serif;MS Sans Serif;MS Serif;MYRIAD;MYRIAD PRO;Palatino;Palatino Linotype;Segoe Print;Segoe Script;Segoe UI;Segoe UI Light;Segoe UI Semibold;Segoe UI Symbol;Tahoma;Times;Times New Roman;Trebuchet MS;Verdana;Wingdings;Wingdings 2;Wingdings 3".split(";"),
                    g = "Abadi MT Condensed Light;Academy Engraved LET;ADOBE CASLON PRO;Adobe Garamond;ADOBE GARAMOND PRO;Agency FB;Aharoni;Albertus Extra Bold;Albertus Medium;Algerian;Amazone BT;American Typewriter;American Typewriter Condensed;AmerType Md BT;Andalus;Angsana New;AngsanaUPC;Antique Olive;Aparajita;Apple Chancery;Apple Color Emoji;Apple SD Gothic Neo;Arabic Typesetting;ARCHER;ARNO PRO;Arrus BT;Aurora Cn BT;AvantGarde Bk BT;AvantGarde Md BT;AVENIR;Ayuthaya;Bandy;Bangla Sangam MN;Bank Gothic;BankGothic Md BT;Baskerville;Baskerville Old Face;Batang;BatangChe;Bauer Bodoni;Bauhaus 93;Bazooka;Bell MT;Bembo;Benguiat Bk BT;Berlin Sans FB;Berlin Sans FB Demi;Bernard MT Condensed;BernhardFashion BT;BernhardMod BT;Big Caslon;BinnerD;Blackadder ITC;BlairMdITC TT;Bodoni 72;Bodoni 72 Oldstyle;Bodoni 72 Smallcaps;Bodoni MT;Bodoni MT Black;Bodoni MT Condensed;Bodoni MT Poster Compressed;Bookshelf Symbol 7;Boulder;Bradley Hand;Bradley Hand ITC;Bremen Bd BT;Britannic Bold;Broadway;Browallia New;BrowalliaUPC;Brush Script MT;Californian FB;Calisto MT;Calligrapher;Candara;CaslonOpnface BT;Castellar;Centaur;Cezanne;CG Omega;CG Times;Chalkboard;Chalkboard SE;Chalkduster;Charlesworth;Charter Bd BT;Charter BT;Chaucer;ChelthmITC Bk BT;Chiller;Clarendon;Clarendon Condensed;CloisterBlack BT;Cochin;Colonna MT;Constantia;Cooper Black;Copperplate;Copperplate Gothic;Copperplate Gothic Bold;Copperplate Gothic Light;CopperplGoth Bd BT;Corbel;Cordia New;CordiaUPC;Cornerstone;Coronet;Cuckoo;Curlz MT;DaunPenh;Dauphin;David;DB LCD Temp;DELICIOUS;Denmark;DFKai-SB;Didot;DilleniaUPC;DIN;DokChampa;Dotum;DotumChe;Ebrima;Edwardian Script ITC;Elephant;English 111 Vivace BT;Engravers MT;EngraversGothic BT;Eras Bold ITC;Eras Demi ITC;Eras Light ITC;Eras Medium ITC;EucrosiaUPC;Euphemia;Euphemia UCAS;EUROSTILE;Exotc350 Bd BT;FangSong;Felix Titling;Fixedsys;FONTIN;Footlight MT Light;Forte;FrankRuehl;Fransiscan;Freefrm721 Blk BT;FreesiaUPC;Freestyle Script;French Script MT;FrnkGothITC Bk BT;Fruitger;FRUTIGER;Futura;Futura Bk BT;Futura Lt BT;Futura Md BT;Futura ZBlk BT;FuturaBlack BT;Gabriola;Galliard BT;Gautami;Geeza Pro;Geometr231 BT;Geometr231 Hv BT;Geometr231 Lt BT;GeoSlab 703 Lt BT;GeoSlab 703 XBd BT;Gigi;Gill Sans;Gill Sans MT;Gill Sans MT Condensed;Gill Sans MT Ext Condensed Bold;Gill Sans Ultra Bold;Gill Sans Ultra Bold Condensed;Gisha;Gloucester MT Extra Condensed;GOTHAM;GOTHAM BOLD;Goudy Old Style;Goudy Stout;GoudyHandtooled BT;GoudyOLSt BT;Gujarati Sangam MN;Gulim;GulimChe;Gungsuh;GungsuhChe;Gurmukhi MN;Haettenschweiler;Harlow Solid Italic;Harrington;Heather;Heiti SC;Heiti TC;HELV;Herald;High Tower Text;Hiragino Kaku Gothic ProN;Hiragino Mincho ProN;Hoefler Text;Humanst 521 Cn BT;Humanst521 BT;Humanst521 Lt BT;Imprint MT Shadow;Incised901 Bd BT;Incised901 BT;Incised901 Lt BT;INCONSOLATA;Informal Roman;Informal011 BT;INTERSTATE;IrisUPC;Iskoola Pota;JasmineUPC;Jazz LET;Jenson;Jester;Jokerman;Juice ITC;Kabel Bk BT;Kabel Ult BT;Kailasa;KaiTi;Kalinga;Kannada Sangam MN;Kartika;Kaufmann Bd BT;Kaufmann BT;Khmer UI;KodchiangUPC;Kokila;Korinna BT;Kristen ITC;Krungthep;Kunstler Script;Lao UI;Latha;Leelawadee;Letter Gothic;Levenim MT;LilyUPC;Lithograph;Lithograph Light;Long Island;Lydian BT;Magneto;Maiandra GD;Malayalam Sangam MN;Malgun Gothic;Mangal;Marigold;Marion;Marker Felt;Market;Marlett;Matisse ITC;Matura MT Script Capitals;Meiryo;Meiryo UI;Microsoft Himalaya;Microsoft JhengHei;Microsoft New Tai Lue;Microsoft PhagsPa;Microsoft Tai Le;Microsoft Uighur;Microsoft YaHei;Microsoft Yi Baiti;MingLiU;MingLiU_HKSCS;MingLiU_HKSCS-ExtB;MingLiU-ExtB;Minion;Minion Pro;Miriam;Miriam Fixed;Mistral;Modern;Modern No. 20;Mona Lisa Solid ITC TT;Mongolian Baiti;MONO;MoolBoran;Mrs Eaves;MS LineDraw;MS Mincho;MS PMincho;MS Reference Specialty;MS UI Gothic;MT Extra;MUSEO;MV Boli;Nadeem;Narkisim;NEVIS;News Gothic;News GothicMT;NewsGoth BT;Niagara Engraved;Niagara Solid;Noteworthy;NSimSun;Nyala;OCR A Extended;Old Century;Old English Text MT;Onyx;Onyx BT;OPTIMA;Oriya Sangam MN;OSAKA;OzHandicraft BT;Palace Script MT;Papyrus;Parchment;Party LET;Pegasus;Perpetua;Perpetua Titling MT;PetitaBold;Pickwick;Plantagenet Cherokee;Playbill;PMingLiU;PMingLiU-ExtB;Poor Richard;Poster;PosterBodoni BT;PRINCETOWN LET;Pristina;PTBarnum BT;Pythagoras;Raavi;Rage Italic;Ravie;Ribbon131 Bd BT;Rockwell;Rockwell Condensed;Rockwell Extra Bold;Rod;Roman;Sakkal Majalla;Santa Fe LET;Savoye LET;Sceptre;Script;Script MT Bold;SCRIPTINA;Serifa;Serifa BT;Serifa Th BT;ShelleyVolante BT;Sherwood;Shonar Bangla;Showcard Gothic;Shruti;Signboard;SILKSCREEN;SimHei;Simplified Arabic;Simplified Arabic Fixed;SimSun;SimSun-ExtB;Sinhala Sangam MN;Sketch Rockwell;Skia;Small Fonts;Snap ITC;Snell Roundhand;Socket;Souvenir Lt BT;Staccato222 BT;Steamer;Stencil;Storybook;Styllo;Subway;Swis721 BlkEx BT;Swiss911 XCm BT;Sylfaen;Synchro LET;System;Tamil Sangam MN;Technical;Teletype;Telugu Sangam MN;Tempus Sans ITC;Terminal;Thonburi;Traditional Arabic;Trajan;TRAJAN PRO;Tristan;Tubular;Tunga;Tw Cen MT;Tw Cen MT Condensed;Tw Cen MT Condensed Extra Bold;TypoUpright BT;Unicorn;Univers;Univers CE 55 Medium;Univers Condensed;Utsaah;Vagabond;Vani;Vijaya;Viner Hand ITC;VisualUI;Vivaldi;Vladimir Script;Vrinda;Westminster;WHITNEY;Wide Latin;ZapfEllipt BT;ZapfHumnst BT;ZapfHumnst Dm BT;Zapfino;Zurich BlkEx BT;Zurich Ex BT;ZWAdobeF".split(";");
                c.options.extendedJsFonts && (f = f.concat(g));
                for (var f = f.concat(c.options.userDefinedFonts), g = document.getElementsByTagName("body")[0], k = document.createElement("div"), q = document.createElement("div"), l = {}, h = {}, r = [], p = 0, u = e.length; p < u; p++) {
                    var w = d();
                    w.style.fontFamily = e[p];
                    k.appendChild(w);
                    r.push(w)
                }
                g.appendChild(k);
                p = 0;
                for (u = e.length; p < u; p++) l[e[p]] = r[p].offsetWidth, h[e[p]] = r[p].offsetHeight;
                r = {};
                p = 0;
                for (u = f.length; p < u; p++) {
                    for (var w = [], R = 0, n = e.length; R < n; R++) {
                        var m;
                        m = f[p];
                        var t = e[R], v = d();
                        v.style.fontFamily =
                            "'" + m + "'," + t;
                        m = v;
                        q.appendChild(m);
                        w.push(m)
                    }
                    r[f[p]] = w
                }
                g.appendChild(q);
                p = [];
                u = 0;
                for (w = f.length; u < w; u++) {
                    R = r[f[u]];
                    n = !1;
                    for (m = 0; m < e.length && !(n = R[m].offsetWidth !== l[e[m]] || R[m].offsetHeight !== h[e[m]]); m++) ;
                    n && p.push(f[u])
                }
                g.removeChild(q);
                g.removeChild(k);
                a.push({key: "js_fonts", value: p});
                b(a)
            }, 1)
        }, pluginsKey: function (a) {
            this.options.excludePlugins || (this.isIE() ? this.options.excludeIEPlugins || a.push({
                key: "ie_plugins",
                value: this.getIEPlugins()
            }) : a.push({key: "regular_plugins", value: this.getRegularPlugins()}));
            return a
        }, getRegularPlugins: function () {
            for (var a = [], b = 0, c = navigator.plugins.length; b < c; b++) a.push(navigator.plugins[b]);
            this.pluginsShouldBeSorted() && (a = a.sort(function (a, b) {
                return a.name > b.name ? 1 : a.name < b.name ? -1 : 0
            }));
            return this.map(a, function (a) {
                var b = this.map(a, function (a) {
                    return [a.type, a.suffixes].join("~")
                }).join(",");
                return [a.name, a.description, b].join("::")
            }, this)
        }, getIEPlugins: function () {
            var a = [];
            if (Object.getOwnPropertyDescriptor && Object.getOwnPropertyDescriptor(window, "ActiveXObject") ||
                "ActiveXObject" in window) a = this.map("AcroPDF.PDF;Adodb.Stream;AgControl.AgControl;DevalVRXCtrl.DevalVRXCtrl.1;MacromediaFlashPaper.MacromediaFlashPaper;Msxml2.DOMDocument;Msxml2.XMLHTTP;PDF.PdfCtrl;QuickTime.QuickTime;QuickTimeCheckObject.QuickTimeCheck.1;RealPlayer;RealPlayer.RealPlayer(tm) ActiveX Control (32-bit);RealVideo.RealVideo(tm) ActiveX Control (32-bit);Scripting.Dictionary;SWCtl.SWCtl;Shell.UIHelper;ShockwaveFlash.ShockwaveFlash;Skype.Detection;TDCCtl.TDCCtl;WMPlayer.OCX;rmocx.RealPlayer G2 Control;rmocx.RealPlayer G2 Control.1".split(";"),
                function (a) {
                    try {
                        return new ActiveXObject(a), a
                    } catch (c) {
                        return null
                    }
                });
            navigator.plugins && (a = a.concat(this.getRegularPlugins()));
            return a
        }, pluginsShouldBeSorted: function () {
            for (var a = !1, b = 0, c = this.options.sortPluginsFor.length; b < c; b++) if (navigator.userAgent.match(this.options.sortPluginsFor[b])) {
                a = !0;
                break
            }
            return a
        }, touchSupportKey: function (a) {
            this.options.excludeTouchSupport || a.push({key: "touch_support", value: this.getTouchSupport()});
            return a
        }, hasSessionStorage: function () {
            try {
                return !!window.sessionStorage
            } catch (a) {
                return !0
            }
        },
        hasLocalStorage: function () {
            try {
                return !!window.localStorage
            } catch (a) {
                return !0
            }
        }, hasIndexedDB: function () {
            try {
                return !!window.indexedDB
            } catch (a) {
                return !0
            }
        }, getNavigatorCpuClass: function () {
            return navigator.cpuClass ? navigator.cpuClass : "unknown"
        }, getNavigatorPlatform: function () {
            return navigator.platform ? navigator.platform : "unknown"
        }, getDoNotTrack: function () {
            return navigator.doNotTrack ? navigator.doNotTrack : navigator.msDoNotTrack ? navigator.msDoNotTrack : window.doNotTrack ? window.doNotTrack : "unknown"
        }, getTouchSupport: function () {
            var a =
                0, b = !1;
            "undefined" !== typeof navigator.maxTouchPoints ? a = navigator.maxTouchPoints : "undefined" !== typeof navigator.msMaxTouchPoints && (a = navigator.msMaxTouchPoints);
            try {
                document.createEvent("TouchEvent"), b = !0
            } catch (c) {
            }
            return [a, b, "ontouchstart" in window]
        }, getCanvasFp: function () {
            var a = [], b = document.createElement("canvas");
            b.width = 2E3;
            b.height = 200;
            b.style.display = "inline";
            var c = b.getContext("2d");
            c.rect(0, 0, 10, 10);
            c.rect(2, 2, 6, 6);
            a.push("canvas winding:" + (!1 === c.isPointInPath(5, 5, "evenodd") ? "yes" : "no"));
            c.textBaseline = "alphabetic";
            c.fillStyle = "#f60";
            c.fillRect(125, 1, 62, 20);
            c.fillStyle = "#069";
            c.font = this.options.dontUseFakeFontInCanvas ? "11pt Arial" : "11pt no-real-font-123";
            c.fillText("Cwm fjordbank glyphs vext quiz, \ud83d\ude03", 2, 15);
            c.fillStyle = "rgba(102, 204, 0, 0.2)";
            c.font = "18pt Arial";
            c.fillText("Cwm fjordbank glyphs vext quiz, \ud83d\ude03", 4, 45);
            c.globalCompositeOperation = "multiply";
            c.fillStyle = "rgb(255,0,255)";
            c.beginPath();
            c.arc(50, 50, 50, 0, 2 * Math.PI, !0);
            c.closePath();
            c.fill();
            c.fillStyle =
                "rgb(0,255,255)";
            c.beginPath();
            c.arc(100, 50, 50, 0, 2 * Math.PI, !0);
            c.closePath();
            c.fill();
            c.fillStyle = "rgb(255,255,0)";
            c.beginPath();
            c.arc(75, 100, 50, 0, 2 * Math.PI, !0);
            c.closePath();
            c.fill();
            c.fillStyle = "rgb(255,0,255)";
            c.arc(75, 75, 75, 0, 2 * Math.PI, !0);
            c.arc(75, 75, 25, 0, 2 * Math.PI, !0);
            c.fill("evenodd");
            a.push("canvas fp:" + b.toDataURL());
            return a.join("~")
        }, getWebglFp: function () {
            function a(a) {
                b.clearColor(0, 0, 0, 1);
                b.enable(b.DEPTH_TEST);
                b.depthFunc(b.LEQUAL);
                b.clear(b.COLOR_BUFFER_BIT | b.DEPTH_BUFFER_BIT);
                return "[" +
                    a[0] + ", " + a[1] + "]"
            }

            var b;
            b = this.getWebglCanvas();
            if (!b) return null;
            var c = [], d = b.createBuffer();
            b.bindBuffer(b.ARRAY_BUFFER, d);
            var e = new Float32Array([-.2, -.9, 0, .4, -.26, 0, 0, .732134444, 0]);
            b.bufferData(b.ARRAY_BUFFER, e, b.STATIC_DRAW);
            d.itemSize = 3;
            d.numItems = 3;
            var e = b.createProgram(), f = b.createShader(b.VERTEX_SHADER);
            b.shaderSource(f, "attribute vec2 attrVertex;varying vec2 varyinTexCoordinate;uniform vec2 uniformOffset;void main(){varyinTexCoordinate\x3dattrVertex+uniformOffset;gl_Position\x3dvec4(attrVertex,0,1);}");
            b.compileShader(f);
            var g = b.createShader(b.FRAGMENT_SHADER);
            b.shaderSource(g, "precision mediump float;varying vec2 varyinTexCoordinate;void main() {gl_FragColor\x3dvec4(varyinTexCoordinate,0,1);}");
            b.compileShader(g);
            b.attachShader(e, f);
            b.attachShader(e, g);
            b.linkProgram(e);
            b.useProgram(e);
            e.vertexPosAttrib = b.getAttribLocation(e, "attrVertex");
            e.offsetUniform = b.getUniformLocation(e, "uniformOffset");
            b.enableVertexAttribArray(e.vertexPosArray);
            b.vertexAttribPointer(e.vertexPosAttrib, d.itemSize, b.FLOAT,
                !1, 0, 0);
            b.uniform2f(e.offsetUniform, 1, 1);
            b.drawArrays(b.TRIANGLE_STRIP, 0, d.numItems);
            null != b.canvas && c.push(b.canvas.toDataURL());
            c.push("extensions:" + b.getSupportedExtensions().join(";"));
            c.push("webgl aliased line width range:" + a(b.getParameter(b.ALIASED_LINE_WIDTH_RANGE)));
            c.push("webgl aliased point size range:" + a(b.getParameter(b.ALIASED_POINT_SIZE_RANGE)));
            c.push("webgl alpha bits:" + b.getParameter(b.ALPHA_BITS));
            c.push("webgl antialiasing:" + (b.getContextAttributes().antialias ? "yes" : "no"));
            c.push("webgl blue bits:" +
                b.getParameter(b.BLUE_BITS));
            c.push("webgl depth bits:" + b.getParameter(b.DEPTH_BITS));
            c.push("webgl green bits:" + b.getParameter(b.GREEN_BITS));
            c.push("webgl max anisotropy:" + function (a) {
                var b,
                    c = a.getExtension("EXT_texture_filter_anisotropic") || a.getExtension("WEBKIT_EXT_texture_filter_anisotropic") || a.getExtension("MOZ_EXT_texture_filter_anisotropic");
                return c ? (b = a.getParameter(c.MAX_TEXTURE_MAX_ANISOTROPY_EXT), 0 === b && (b = 2), b) : null
            }(b));
            c.push("webgl max combined texture image units:" + b.getParameter(b.MAX_COMBINED_TEXTURE_IMAGE_UNITS));
            c.push("webgl max cube map texture size:" + b.getParameter(b.MAX_CUBE_MAP_TEXTURE_SIZE));
            c.push("webgl max fragment uniform vectors:" + b.getParameter(b.MAX_FRAGMENT_UNIFORM_VECTORS));
            c.push("webgl max render buffer size:" + b.getParameter(b.MAX_RENDERBUFFER_SIZE));
            c.push("webgl max texture image units:" + b.getParameter(b.MAX_TEXTURE_IMAGE_UNITS));
            c.push("webgl max texture size:" + b.getParameter(b.MAX_TEXTURE_SIZE));
            c.push("webgl max varying vectors:" + b.getParameter(b.MAX_VARYING_VECTORS));
            c.push("webgl max vertex attribs:" +
                b.getParameter(b.MAX_VERTEX_ATTRIBS));
            c.push("webgl max vertex texture image units:" + b.getParameter(b.MAX_VERTEX_TEXTURE_IMAGE_UNITS));
            c.push("webgl max vertex uniform vectors:" + b.getParameter(b.MAX_VERTEX_UNIFORM_VECTORS));
            c.push("webgl max viewport dims:" + a(b.getParameter(b.MAX_VIEWPORT_DIMS)));
            c.push("webgl red bits:" + b.getParameter(b.RED_BITS));
            c.push("webgl renderer:" + b.getParameter(b.RENDERER));
            c.push("webgl shading language version:" + b.getParameter(b.SHADING_LANGUAGE_VERSION));
            c.push("webgl stencil bits:" +
                b.getParameter(b.STENCIL_BITS));
            c.push("webgl vendor:" + b.getParameter(b.VENDOR));
            c.push("webgl version:" + b.getParameter(b.VERSION));
            if (!b.getShaderPrecisionFormat) return c.join("~");
            c.push("webgl vertex shader high float precision:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.HIGH_FLOAT).precision);
            c.push("webgl vertex shader high float precision rangeMin:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.HIGH_FLOAT).rangeMin);
            c.push("webgl vertex shader high float precision rangeMax:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER,
                b.HIGH_FLOAT).rangeMax);
            c.push("webgl vertex shader medium float precision:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.MEDIUM_FLOAT).precision);
            c.push("webgl vertex shader medium float precision rangeMin:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.MEDIUM_FLOAT).rangeMin);
            c.push("webgl vertex shader medium float precision rangeMax:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.MEDIUM_FLOAT).rangeMax);
            c.push("webgl vertex shader low float precision:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER,
                b.LOW_FLOAT).precision);
            c.push("webgl vertex shader low float precision rangeMin:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.LOW_FLOAT).rangeMin);
            c.push("webgl vertex shader low float precision rangeMax:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.LOW_FLOAT).rangeMax);
            c.push("webgl fragment shader high float precision:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.HIGH_FLOAT).precision);
            c.push("webgl fragment shader high float precision rangeMin:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER,
                b.HIGH_FLOAT).rangeMin);
            c.push("webgl fragment shader high float precision rangeMax:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.HIGH_FLOAT).rangeMax);
            c.push("webgl fragment shader medium float precision:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.MEDIUM_FLOAT).precision);
            c.push("webgl fragment shader medium float precision rangeMin:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.MEDIUM_FLOAT).rangeMin);
            c.push("webgl fragment shader medium float precision rangeMax:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER,
                b.MEDIUM_FLOAT).rangeMax);
            c.push("webgl fragment shader low float precision:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.LOW_FLOAT).precision);
            c.push("webgl fragment shader low float precision rangeMin:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.LOW_FLOAT).rangeMin);
            c.push("webgl fragment shader low float precision rangeMax:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.LOW_FLOAT).rangeMax);
            c.push("webgl vertex shader high int precision:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.HIGH_INT).precision);
            c.push("webgl vertex shader high int precision rangeMin:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.HIGH_INT).rangeMin);
            c.push("webgl vertex shader high int precision rangeMax:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.HIGH_INT).rangeMax);
            c.push("webgl vertex shader medium int precision:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.MEDIUM_INT).precision);
            c.push("webgl vertex shader medium int precision rangeMin:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.MEDIUM_INT).rangeMin);
            c.push("webgl vertex shader medium int precision rangeMax:" +
                b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.MEDIUM_INT).rangeMax);
            c.push("webgl vertex shader low int precision:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.LOW_INT).precision);
            c.push("webgl vertex shader low int precision rangeMin:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.LOW_INT).rangeMin);
            c.push("webgl vertex shader low int precision rangeMax:" + b.getShaderPrecisionFormat(b.VERTEX_SHADER, b.LOW_INT).rangeMax);
            c.push("webgl fragment shader high int precision:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER,
                b.HIGH_INT).precision);
            c.push("webgl fragment shader high int precision rangeMin:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.HIGH_INT).rangeMin);
            c.push("webgl fragment shader high int precision rangeMax:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.HIGH_INT).rangeMax);
            c.push("webgl fragment shader medium int precision:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.MEDIUM_INT).precision);
            c.push("webgl fragment shader medium int precision rangeMin:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER,
                b.MEDIUM_INT).rangeMin);
            c.push("webgl fragment shader medium int precision rangeMax:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.MEDIUM_INT).rangeMax);
            c.push("webgl fragment shader low int precision:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.LOW_INT).precision);
            c.push("webgl fragment shader low int precision rangeMin:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER, b.LOW_INT).rangeMin);
            c.push("webgl fragment shader low int precision rangeMax:" + b.getShaderPrecisionFormat(b.FRAGMENT_SHADER,
                b.LOW_INT).rangeMax);
            return c.join("~")
        }, getWebglVendorAndRenderer: function () {
            try {
                var a = this.getWebglCanvas(), b = a.getExtension("WEBGL_debug_renderer_info");
                return a.getParameter(b.UNMASKED_VENDOR_WEBGL) + "~" + a.getParameter(b.UNMASKED_RENDERER_WEBGL)
            } catch (c) {
                return null
            }
        }, getAdBlock: function () {
            var a = document.createElement("div");
            a.innerHTML = "\x26nbsp;";
            a.className = "adsbox";
            var b = "0";
            try {
                document.body.appendChild(a), 0 === document.getElementsByClassName("adsbox")[0].offsetHeight && (b = "1"), document.body.removeChild(a)
            } catch (c) {
                b =
                    "0"
            }
            return b
        }, getHasLiedLanguages: function () {
            if ("undefined" !== typeof navigator.languages) try {
                if (navigator.languages[0].substr(0, 2) !== navigator.language.substr(0, 2)) return !0
            } catch (a) {
                return !0
            }
            return !1
        }, getHasLiedResolution: function () {
            return screen.width < screen.availWidth || screen.height < screen.availHeight ? !0 : !1
        }, getHasLiedOs: function () {
            var a = navigator.userAgent.toLowerCase(), b = navigator.oscpu, c = navigator.platform.toLowerCase(),
                a = 0 <= a.indexOf("windows phone") ? "Windows Phone" : 0 <= a.indexOf("win") ? "Windows" :
                    0 <= a.indexOf("android") ? "Android" : 0 <= a.indexOf("linux") ? "Linux" : 0 <= a.indexOf("iphone") || 0 <= a.indexOf("ipad") ? "iOS" : 0 <= a.indexOf("mac") ? "Mac" : "Other";
            return ("ontouchstart" in window || 0 < navigator.maxTouchPoints || 0 < navigator.msMaxTouchPoints) && "Windows Phone" !== a && "Android" !== a && "iOS" !== a && "Other" !== a || "undefined" !== typeof b && (b = b.toLowerCase(), 0 <= b.indexOf("win") && "Windows" !== a && "Windows Phone" !== a || 0 <= b.indexOf("linux") && "Linux" !== a && "Android" !== a || 0 <= b.indexOf("mac") && "Mac" !== a && "iOS" !== a || 0 === b.indexOf("win") &&
            0 === b.indexOf("linux") && 0 <= b.indexOf("mac") && "other" !== a) ? !0 : 0 <= c.indexOf("win") && "Windows" !== a && "Windows Phone" !== a || (0 <= c.indexOf("linux") || 0 <= c.indexOf("android") || 0 <= c.indexOf("pike")) && "Linux" !== a && "Android" !== a || (0 <= c.indexOf("mac") || 0 <= c.indexOf("ipad") || 0 <= c.indexOf("ipod") || 0 <= c.indexOf("iphone")) && "Mac" !== a && "iOS" !== a || 0 === c.indexOf("win") && 0 === c.indexOf("linux") && 0 <= c.indexOf("mac") && "other" !== a ? !0 : "undefined" === typeof navigator.plugins && "Windows" !== a && "Windows Phone" !== a ? !0 : !1
        }, getHasLiedBrowser: function () {
            var a =
                    navigator.userAgent.toLowerCase(), b = navigator.productSub,
                a = 0 <= a.indexOf("firefox") ? "Firefox" : 0 <= a.indexOf("opera") || 0 <= a.indexOf("opr") ? "Opera" : 0 <= a.indexOf("chrome") ? "Chrome" : 0 <= a.indexOf("safari") ? "Safari" : 0 <= a.indexOf("trident") ? "Internet Explorer" : "Other";
            if (("Chrome" === a || "Safari" === a || "Opera" === a) && "20030107" !== b) return !0;
            b = eval.toString().length;
            if (37 === b && "Safari" !== a && "Firefox" !== a && "Other" !== a || 39 === b && "Internet Explorer" !== a && "Other" !== a || 33 === b && "Chrome" !== a && "Opera" !== a && "Other" !== a) return !0;
            var c;
            try {
                throw"a";
            } catch (d) {
                try {
                    d.toSource(), c = !0
                } catch (e) {
                    c = !1
                }
            }
            return c && "Firefox" !== a && "Other" !== a ? !0 : !1
        }, isCanvasSupported: function () {
            var a = document.createElement("canvas");
            return !(!a.getContext || !a.getContext("2d"))
        }, isWebGlSupported: function () {
            if (!this.isCanvasSupported()) return !1;
            var a = document.createElement("canvas"), b;
            try {
                b = a.getContext && (a.getContext("webgl") || a.getContext("experimental-webgl"))
            } catch (c) {
                b = !1
            }
            return !!window.WebGLRenderingContext && !!b
        }, isIE: function () {
            return "Microsoft Internet Explorer" ===
            navigator.appName || "Netscape" === navigator.appName && /Trident/.test(navigator.userAgent) ? !0 : !1
        }, hasSwfObjectLoaded: function () {
            return "undefined" !== typeof window.swfobject
        }, hasMinFlashInstalled: function () {
            return S.hasFlashPlayerVersion("9.0.0")
        }, addFlashDivNode: function () {
            var a = document.createElement("div");
            a.setAttribute("id", this.options.swfContainerId);
            document.body.appendChild(a)
        }, loadSwfAndDetectFonts: function (a) {
            window.___fp_swf_loaded = function (b) {
                a(b)
            };
            var b = this.options.swfContainerId;
            this.addFlashDivNode();
            S.embedSWF(this.options.swfPath, b, "1", "1", "9.0.0", !1, {onReady: "___fp_swf_loaded"}, {
                allowScriptAccess: "always",
                menu: "false"
            }, {})
        }, getWebglCanvas: function () {
            var a = document.createElement("canvas"), b = null;
            try {
                b = a.getContext("webgl") || a.getContext("experimental-webgl")
            } catch (c) {
            }
            b || (b = null);
            return b
        }, each: function (a, b, c) {
            if (null !== a) if (this.nativeForEach && a.forEach === this.nativeForEach) a.forEach(b, c); else if (a.length === +a.length) for (var d = 0, e = a.length; d < e && b.call(c, a[d], d, a) !== {}; d++) ; else for (d in a) if (a.hasOwnProperty(d) &&
                b.call(c, a[d], d, a) === {}) break
        }, map: function (a, b, c) {
            var d = [];
            if (null == a) return d;
            if (this.nativeMap && a.map === this.nativeMap) return a.map(b, c);
            this.each(a, function (a, f, g) {
                d[d.length] = b.call(c, a, f, g)
            });
            return d
        }, x64Add: function (a, b) {
            a = [a[0] >>> 16, a[0] & 65535, a[1] >>> 16, a[1] & 65535];
            b = [b[0] >>> 16, b[0] & 65535, b[1] >>> 16, b[1] & 65535];
            var c = [0, 0, 0, 0];
            c[3] += a[3] + b[3];
            c[2] += c[3] >>> 16;
            c[3] &= 65535;
            c[2] += a[2] + b[2];
            c[1] += c[2] >>> 16;
            c[2] &= 65535;
            c[1] += a[1] + b[1];
            c[0] += c[1] >>> 16;
            c[1] &= 65535;
            c[0] += a[0] + b[0];
            c[0] &= 65535;
            return [c[0] <<
            16 | c[1], c[2] << 16 | c[3]]
        }, x64Multiply: function (a, b) {
            a = [a[0] >>> 16, a[0] & 65535, a[1] >>> 16, a[1] & 65535];
            b = [b[0] >>> 16, b[0] & 65535, b[1] >>> 16, b[1] & 65535];
            var c = [0, 0, 0, 0];
            c[3] += a[3] * b[3];
            c[2] += c[3] >>> 16;
            c[3] &= 65535;
            c[2] += a[2] * b[3];
            c[1] += c[2] >>> 16;
            c[2] &= 65535;
            c[2] += a[3] * b[2];
            c[1] += c[2] >>> 16;
            c[2] &= 65535;
            c[1] += a[1] * b[3];
            c[0] += c[1] >>> 16;
            c[1] &= 65535;
            c[1] += a[2] * b[2];
            c[0] += c[1] >>> 16;
            c[1] &= 65535;
            c[1] += a[3] * b[1];
            c[0] += c[1] >>> 16;
            c[1] &= 65535;
            c[0] += a[0] * b[3] + a[1] * b[2] + a[2] * b[1] + a[3] * b[0];
            c[0] &= 65535;
            return [c[0] << 16 | c[1],
                c[2] << 16 | c[3]]
        }, x64Rotl: function (a, b) {
            b %= 64;
            if (32 === b) return [a[1], a[0]];
            if (32 > b) return [a[0] << b | a[1] >>> 32 - b, a[1] << b | a[0] >>> 32 - b];
            b -= 32;
            return [a[1] << b | a[0] >>> 32 - b, a[0] << b | a[1] >>> 32 - b]
        }, x64LeftShift: function (a, b) {
            b %= 64;
            return 0 === b ? a : 32 > b ? [a[0] << b | a[1] >>> 32 - b, a[1] << b] : [a[1] << b - 32, 0]
        }, x64Xor: function (a, b) {
            return [a[0] ^ b[0], a[1] ^ b[1]]
        }, x64Fmix: function (a) {
            a = this.x64Xor(a, [0, a[0] >>> 1]);
            a = this.x64Multiply(a, [4283543511, 3981806797]);
            a = this.x64Xor(a, [0, a[0] >>> 1]);
            a = this.x64Multiply(a, [3301882366, 444984403]);
            return a = this.x64Xor(a, [0, a[0] >>> 1])
        }, x64hash128: function (a, b) {
            a = a || "";
            b = b || 0;
            for (var c = a.length % 16, d = a.length - c, e = [0, b], f = [0, b], g, k, q = [2277735313, 289559509], l = [1291169091, 658871167], h = 0; h < d; h += 16) g = [a.charCodeAt(h + 4) & 255 | (a.charCodeAt(h + 5) & 255) << 8 | (a.charCodeAt(h + 6) & 255) << 16 | (a.charCodeAt(h + 7) & 255) << 24, a.charCodeAt(h) & 255 | (a.charCodeAt(h + 1) & 255) << 8 | (a.charCodeAt(h + 2) & 255) << 16 | (a.charCodeAt(h + 3) & 255) << 24], k = [a.charCodeAt(h + 12) & 255 | (a.charCodeAt(h + 13) & 255) << 8 | (a.charCodeAt(h + 14) & 255) << 16 | (a.charCodeAt(h +
                15) & 255) << 24, a.charCodeAt(h + 8) & 255 | (a.charCodeAt(h + 9) & 255) << 8 | (a.charCodeAt(h + 10) & 255) << 16 | (a.charCodeAt(h + 11) & 255) << 24], g = this.x64Multiply(g, q), g = this.x64Rotl(g, 31), g = this.x64Multiply(g, l), e = this.x64Xor(e, g), e = this.x64Rotl(e, 27), e = this.x64Add(e, f), e = this.x64Add(this.x64Multiply(e, [0, 5]), [0, 1390208809]), k = this.x64Multiply(k, l), k = this.x64Rotl(k, 33), k = this.x64Multiply(k, q), f = this.x64Xor(f, k), f = this.x64Rotl(f, 31), f = this.x64Add(f, e), f = this.x64Add(this.x64Multiply(f, [0, 5]), [0, 944331445]);
            g = [0, 0];
            k = [0,
                0];
            switch (c) {
                case 15:
                    k = this.x64Xor(k, this.x64LeftShift([0, a.charCodeAt(h + 14)], 48));
                case 14:
                    k = this.x64Xor(k, this.x64LeftShift([0, a.charCodeAt(h + 13)], 40));
                case 13:
                    k = this.x64Xor(k, this.x64LeftShift([0, a.charCodeAt(h + 12)], 32));
                case 12:
                    k = this.x64Xor(k, this.x64LeftShift([0, a.charCodeAt(h + 11)], 24));
                case 11:
                    k = this.x64Xor(k, this.x64LeftShift([0, a.charCodeAt(h + 10)], 16));
                case 10:
                    k = this.x64Xor(k, this.x64LeftShift([0, a.charCodeAt(h + 9)], 8));
                case 9:
                    k = this.x64Xor(k, [0, a.charCodeAt(h + 8)]), k = this.x64Multiply(k, l),
                        k = this.x64Rotl(k, 33), k = this.x64Multiply(k, q), f = this.x64Xor(f, k);
                case 8:
                    g = this.x64Xor(g, this.x64LeftShift([0, a.charCodeAt(h + 7)], 56));
                case 7:
                    g = this.x64Xor(g, this.x64LeftShift([0, a.charCodeAt(h + 6)], 48));
                case 6:
                    g = this.x64Xor(g, this.x64LeftShift([0, a.charCodeAt(h + 5)], 40));
                case 5:
                    g = this.x64Xor(g, this.x64LeftShift([0, a.charCodeAt(h + 4)], 32));
                case 4:
                    g = this.x64Xor(g, this.x64LeftShift([0, a.charCodeAt(h + 3)], 24));
                case 3:
                    g = this.x64Xor(g, this.x64LeftShift([0, a.charCodeAt(h + 2)], 16));
                case 2:
                    g = this.x64Xor(g, this.x64LeftShift([0,
                        a.charCodeAt(h + 1)], 8));
                case 1:
                    g = this.x64Xor(g, [0, a.charCodeAt(h)]), g = this.x64Multiply(g, q), g = this.x64Rotl(g, 31), g = this.x64Multiply(g, l), e = this.x64Xor(e, g)
            }
            e = this.x64Xor(e, [0, a.length]);
            f = this.x64Xor(f, [0, a.length]);
            e = this.x64Add(e, f);
            f = this.x64Add(f, e);
            e = this.x64Fmix(e);
            f = this.x64Fmix(f);
            e = this.x64Add(e, f);
            f = this.x64Add(f, e);
            return ("00000000" + (e[0] >>> 0).toString(16)).slice(-8) + ("00000000" + (e[1] >>> 0).toString(16)).slice(-8) + ("00000000" + (f[0] >>> 0).toString(16)).slice(-8) + ("00000000" + (f[1] >>> 0).toString(16)).slice(-8)
        }
    };
    V.VERSION = "1.4.2";
    var Wa = {
            touchSupport: "wNLf",
            scrHeight: "5Jwy",
            scrAvailSize: "TeRS",
            hasLiedLanguages: "j5po",
            adblock: "FMQw",
            flashVersion: "dzuS",
            browserVersion: "d435",
            indexedDb: "3sw-",
            userAgent: "0aew",
            browserName: "-UVA",
            plugins: "ks0Q",
            jsFonts: "EOQP",
            scrColorDepth: "qmyu",
            userLanguage: "hLzX",
            hasLiedOs: "ci5c",
            timeZone: "q5aJ",
            mimeTypes: "jp76",
            localCode: "lEnu",
            online: "9vyE",
            javaEnabled: "yD16",
            historyList: "kU5z",
            storeDb: "Fvje",
            webSmartID: "E3gR",
            doNotTrack: "VEek",
            appMinorVersion: "qBVW",
            localStorage: "XM7l",
            hasLiedResolution: "3neK",
            sessionStorage: "HVia",
            cookieEnabled: "VPIf",
            os: "hAqN",
            srcScreenSize: "tOHY",
            hasLiedBrowser: "2xC5",
            openDatabase: "V8vl",
            scrWidth: "ssI5",
            appcodeName: "qT7b",
            scrAvailHeight: "88tV",
            browserLanguage: "q4f3",
            cpuClass: "Md7A",
            scrAvailWidth: "E-lJ",
            systemLanguage: "e6OK",
            cookieCode: "VySQ",
            scrDeviceXDPI: "3jCe"
        },
        jb = "appCodeName appMinorVersion appName cpuClass onLine systemLanguage userLanguage historyList hasLiedLanguages hasLiedResolution hasLiedOs hasLiedBrowser".split(" "),
        kb = ["sessionStorage",
            "localStorage", "indexedDb", "openDatabase"], lb = ["scrAvailWidth", "scrAvailHeight"],
        mb = ["scrDeviceXDPI", "scrColorDepth", "scrWidth", "scrHeight"], Ea;
    if (!(Ea = X)) {
        var Y = Math, la = {}, ma = la.lib = {}, Xa = function () {
        }, Z = ma.Base = {
            extend: function (a) {
                Xa.prototype = this;
                var b = new Xa;
                a && b.mixIn(a);
                b.hasOwnProperty("init") || (b.init = function () {
                    b.$super.init.apply(this, arguments)
                });
                b.init.prototype = b;
                b.$super = this;
                return b
            }, create: function () {
                var a = this.extend();
                a.init.apply(a, arguments);
                return a
            }, init: function () {
            }, mixIn: function (a) {
                for (var b in a) a.hasOwnProperty(b) &&
                (this[b] = a[b]);
                a.hasOwnProperty("toString") && (this.toString = a.toString)
            }, clone: function () {
                return this.init.prototype.extend(this)
            }
        }, aa = ma.WordArray = Z.extend({
            init: function (a, b) {
                a = this.words = a || [];
                this.sigBytes = void 0 != b ? b : 4 * a.length
            }, toString: function (a) {
                return (a || nb).stringify(this)
            }, concat: function (a) {
                var b = this.words, c = a.words, d = this.sigBytes;
                a = a.sigBytes;
                this.clamp();
                if (d % 4) for (var e = 0; e < a; e++) b[d + e >>> 2] |= (c[e >>> 2] >>> 24 - e % 4 * 8 & 255) << 24 - (d + e) % 4 * 8; else if (65535 < c.length) for (e = 0; e < a; e += 4) b[d + e >>>
                2] = c[e >>> 2]; else b.push.apply(b, c);
                this.sigBytes += a;
                return this
            }, clamp: function () {
                var a = this.words, b = this.sigBytes;
                a[b >>> 2] &= 4294967295 << 32 - b % 4 * 8;
                a.length = Y.ceil(b / 4)
            }, clone: function () {
                var a = Z.clone.call(this);
                a.words = this.words.slice(0);
                return a
            }, random: function (a) {
                for (var b = [], c = 0; c < a; c += 4) b.push(4294967296 * Y.random() | 0);
                return new aa.init(b, a)
            }
        }), Fa = la.enc = {}, nb = Fa.Hex = {
            stringify: function (a) {
                var b = a.words;
                a = a.sigBytes;
                for (var c = [], d = 0; d < a; d++) {
                    var e = b[d >>> 2] >>> 24 - d % 4 * 8 & 255;
                    c.push((e >>> 4).toString(16));
                    c.push((e & 15).toString(16))
                }
                return c.join("")
            }, parse: function (a) {
                for (var b = a.length, c = [], d = 0; d < b; d += 2) c[d >>> 3] |= parseInt(a.substr(d, 2), 16) << 24 - d % 8 * 4;
                return new aa.init(c, b / 2)
            }
        }, Ya = Fa.Latin1 = {
            stringify: function (a) {
                var b = a.words;
                a = a.sigBytes;
                for (var c = [], d = 0; d < a; d++) c.push(String.fromCharCode(b[d >>> 2] >>> 24 - d % 4 * 8 & 255));
                return c.join("")
            }, parse: function (a) {
                for (var b = a.length, c = [], d = 0; d < b; d++) c[d >>> 2] |= (a.charCodeAt(d) & 255) << 24 - d % 4 * 8;
                return new aa.init(c, b)
            }
        }, ob = Fa.Utf8 = {
            stringify: function (a) {
                try {
                    return decodeURIComponent(escape(Ya.stringify(a)))
                } catch (b) {
                    throw Error("Malformed UTF-8 data");
                }
            }, parse: function (a) {
                return Ya.parse(unescape(encodeURIComponent(a)))
            }
        }, Za = ma.BufferedBlockAlgorithm = Z.extend({
            reset: function () {
                this._data = new aa.init;
                this._nDataBytes = 0
            }, _append: function (a) {
                "string" == typeof a && (a = ob.parse(a));
                this._data.concat(a);
                this._nDataBytes += a.sigBytes
            }, _process: function (a) {
                var b = this._data, c = b.words, d = b.sigBytes, e = this.blockSize, f = d / (4 * e),
                    f = a ? Y.ceil(f) : Y.max((f | 0) - this._minBufferSize, 0);
                a = f * e;
                d = Y.min(4 * a, d);
                if (a) {
                    for (var g = 0; g < a; g += e) this._doProcessBlock(c, g);
                    g = c.splice(0,
                        a);
                    b.sigBytes -= d
                }
                return new aa.init(g, d)
            }, clone: function () {
                var a = Z.clone.call(this);
                a._data = this._data.clone();
                return a
            }, _minBufferSize: 0
        });
        ma.Hasher = Za.extend({
            cfg: Z.extend(), init: function (a) {
                this.cfg = this.cfg.extend(a);
                this.reset()
            }, reset: function () {
                Za.reset.call(this);
                this._doReset()
            }, update: function (a) {
                this._append(a);
                this._process();
                return this
            }, finalize: function (a) {
                a && this._append(a);
                return this._doFinalize()
            }, blockSize: 16, _createHelper: function (a) {
                return function (b, c) {
                    return (new a.init(c)).finalize(b)
                }
            },
            _createHmacHelper: function (a) {
                return function (b, c) {
                    return (new pb.HMAC.init(a, c)).finalize(b)
                }
            }
        });
        var pb = la.algo = {};
        Ea = la
    }
    for (var X = Ea, na = Math, oa = X, M = oa.lib, qb = M.WordArray, pa = M.Hasher, M = oa.algo, $a = [], ab = [], qa = 2, ba = 0; 64 > ba;) {
        var T;
        a:{
            T = qa;
            for (var rb = na.sqrt(T), Ga = 2; Ga <= rb; Ga++) if (!(T % Ga)) {
                T = !1;
                break a
            }
            T = !0
        }
        T && (8 > ba && ($a[ba] = Ua(na.pow(qa, .5))), ab[ba] = Ua(na.pow(qa, 1 / 3)), ba++);
        qa++
    }
    var N = [], M = M.SHA256 = pa.extend({
        _doReset: function () {
            this._hash = new qb.init($a.slice(0))
        }, _doProcessBlock: function (a, b) {
            for (var c =
                this._hash.words, d = c[0], e = c[1], f = c[2], g = c[3], k = c[4], q = c[5], l = c[6], h = c[7], r = 0; 64 > r; r++) {
                if (16 > r) N[r] = a[b + r] | 0; else {
                    var p = N[r - 15], u = N[r - 2];
                    N[r] = ((p << 25 | p >>> 7) ^ (p << 14 | p >>> 18) ^ p >>> 3) + N[r - 7] + ((u << 15 | u >>> 17) ^ (u << 13 | u >>> 19) ^ u >>> 10) + N[r - 16]
                }
                p = h + ((k << 26 | k >>> 6) ^ (k << 21 | k >>> 11) ^ (k << 7 | k >>> 25)) + (k & q ^ ~k & l) + ab[r] + N[r];
                u = ((d << 30 | d >>> 2) ^ (d << 19 | d >>> 13) ^ (d << 10 | d >>> 22)) + (d & e ^ d & f ^ e & f);
                h = l;
                l = q;
                q = k;
                k = g + p | 0;
                g = f;
                f = e;
                e = d;
                d = p + u | 0
            }
            c[0] = c[0] + d | 0;
            c[1] = c[1] + e | 0;
            c[2] = c[2] + f | 0;
            c[3] = c[3] + g | 0;
            c[4] = c[4] + k | 0;
            c[5] = c[5] + q | 0;
            c[6] = c[6] + l |
                0;
            c[7] = c[7] + h | 0
        }, _doFinalize: function () {
            var a = this._data, b = a.words, c = 8 * this._nDataBytes, d = 8 * a.sigBytes;
            b[d >>> 5] |= 128 << 24 - d % 32;
            b[(d + 64 >>> 9 << 4) + 14] = na.floor(c / 4294967296);
            b[(d + 64 >>> 9 << 4) + 15] = c;
            a.sigBytes = 4 * b.length;
            this._process();
            return this._hash
        }, clone: function () {
            var a = pa.clone.call(this);
            a._hash = this._hash.clone();
            return a
        }
    });
    oa.SHA256 = pa._createHelper(M);
    oa.HmacSHA256 = pa._createHmacHelper(M);
    var bb = X, sb = bb.lib.WordArray;
    bb.enc.Base64 = {
        stringify: function (a) {
            var b = a.words, c = a.sigBytes, d = this._map;
            a.clamp();
            a = [];
            for (var e = 0; e < c; e += 3) for (var f = (b[e >>> 2] >>> 24 - e % 4 * 8 & 255) << 16 | (b[e + 1 >>> 2] >>> 24 - (e + 1) % 4 * 8 & 255) << 8 | b[e + 2 >>> 2] >>> 24 - (e + 2) % 4 * 8 & 255, g = 0; 4 > g && e + .75 * g < c; g++) a.push(d.charAt(f >>> 6 * (3 - g) & 63));
            if (b = d.charAt(64)) for (; a.length % 4;) a.push(b);
            return a.join("")
        }, parse: function (a) {
            var b = a.length, c = this._map, d = c.charAt(64);
            d && (d = a.indexOf(d), -1 != d && (b = d));
            for (var d = [], e = 0, f = 0; f < b; f++) if (f % 4) {
                var g = c.indexOf(a.charAt(f - 1)) << f % 4 * 2, k = c.indexOf(a.charAt(f)) >>> 6 - f % 4 * 2;
                d[e >>> 2] |= (g | k) << 24 - e % 4 * 8;
                e++
            }
            return sb.create(d,
                e)
        }, _map: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_"
    };
    Array.prototype.indexOf || (Array.prototype.indexOf = function (a, b) {
        var c;
        if (null == this) throw new TypeError('"this" is null or not defined');
        var d = Object(this), e = d.length >>> 0;
        if (0 === e) return -1;
        c = +b || 0;
        Infinity === Math.abs(c) && (c = 0);
        if (c >= e) return -1;
        for (c = Math.max(0 <= c ? c : e - Math.abs(c), 0); c < e;) {
            if (c in d && d[c] === a) return c;
            c++
        }
        return -1
    });
    var S, E = window, t = document, J = navigator, cb = !1, ja = [function () {
            if (cb) {
                var a = t.getElementsByTagName("body")[0],
                    b = t.createElement("object");
                b.setAttribute("type", "application/x-shockwave-flash");
                var c = a.appendChild(b);
                if (c) {
                    var d = 0;
                    (function f() {
                        if ("undefined" != typeof c.GetVariable) {
                            var g = c.GetVariable("$version");
                            g && (g = g.split(" ")[1].split(","), n.pv = [parseInt(g[0], 10), parseInt(g[1], 10), parseInt(g[2], 10)])
                        } else if (10 > d) {
                            d++;
                            setTimeout(f, 10);
                            return
                        }
                        a.removeChild(b);
                        c = null;
                        Ba()
                    })()
                } else Ba()
            } else Ba()
        }], I = [], ga = [], O = [], U, ia, ya, Ra, L = !1, ha = !1, H, ua, Oa = !0, n,
        tb = "undefined" != typeof t.getElementById && "undefined" !=
            typeof t.getElementsByTagName && "undefined" != typeof t.createElement, ra = J.userAgent.toLowerCase(),
        sa = J.platform.toLowerCase(), ub = sa ? /win/.test(sa) : /win/.test(ra),
        vb = sa ? /mac/.test(sa) : /mac/.test(ra),
        wb = /webkit/.test(ra) ? parseFloat(ra.replace(/^.*webkit\/(\d+(\.\d+)?).*$/, "$1")) : !1, Ha = !+"\v1",
        ca = [0, 0, 0], D = null;
    if ("undefined" != typeof J.plugins && "object" == typeof J.plugins["Shockwave Flash"]) !(D = J.plugins["Shockwave Flash"].description) || "undefined" != typeof J.mimeTypes && J.mimeTypes["application/x-shockwave-flash"] &&
    !J.mimeTypes["application/x-shockwave-flash"].enabledPlugin || (cb = !0, Ha = !1, D = D.replace(/^.*\s+(\S+\s+\S+$)/, "$1"), ca[0] = parseInt(D.replace(/^(.*)\..*$/, "$1"), 10), ca[1] = parseInt(D.replace(/^.*\.(.*)\s.*$/, "$1"), 10), ca[2] = /[a-zA-Z]/.test(D) ? parseInt(D.replace(/^.*[a-zA-Z]+(.*)$/, "$1"), 10) : 0); else if ("undefined" != typeof E.ActiveXObject) try {
        if (D = (new ActiveXObject("ShockwaveFlash.ShockwaveFlash")).GetVariable("$version")) Ha = !0, D = D.split(" ")[1].split(","), ca = [parseInt(D[0], 10), parseInt(D[1], 10), parseInt(D[2],
            10)]
    } catch (a) {
    }
    n = {w3: tb, pv: ca, wk: wb, ie: Ha, win: ub, mac: vb};
    n.w3 && (("undefined" != typeof t.readyState && "complete" == t.readyState || "undefined" == typeof t.readyState && (t.getElementsByTagName("body")[0] || t.body)) && P(), L || ("undefined" != typeof t.addEventListener && t.addEventListener("DOMContentLoaded", P, !1), n.ie && n.win && (t.attachEvent("onreadystatechange", function b() {
        "complete" == t.readyState && (t.detachEvent("onreadystatechange", b), P())
    }), E == top && function c() {
        if (!L) {
            try {
                t.documentElement.doScroll("left")
            } catch (d) {
                setTimeout(c,
                    0);
                return
            }
            P()
        }
    }()), n.wk && function b() {
        L || (/loaded|complete/.test(t.readyState) ? P() : setTimeout(b, 0))
    }(), Sa(P)));
    n.ie && n.win && window.attachEvent("onunload", function () {
        for (var a = O.length, b = 0; b < a; b++) O[b][0].detachEvent(O[b][1], O[b][2]);
        a = ga.length;
        for (b = 0; b < a; b++) Qa(ga[b]);
        for (var c in n) n[c] = null;
        n = null;
        for (var d in S) S[d] = null;
        S = null
    });
    S = {
        registerObject: function (a, b, c, d) {
            if (n.w3 && a && b) {
                var e = {};
                e.id = a;
                e.swfVersion = b;
                e.expressInstall = c;
                e.callbackFn = d;
                I[I.length] = e;
                K(a, !1)
            } else d && d({success: !1, id: a})
        },
        getObjectById: function (a) {
            if (n.w3) return Aa(a)
        }, embedSWF: function (a, b, c, d, e, f, g, k, q, l) {
            var h = {success: !1, id: b};
            n.w3 && !(n.wk && 312 > n.wk) && a && b && c && d && e ? (K(b, !1), Ta(function () {
                c += "";
                d += "";
                var r = {};
                if (q && "object" === typeof q) for (var p in q) r[p] = q[p];
                r.data = a;
                r.width = c;
                r.height = d;
                p = {};
                if (k && "object" === typeof k) for (var u in k) p[u] = k[u];
                if (g && "object" === typeof g) for (var w in g) p.flashvars = "undefined" != typeof p.flashvars ? p.flashvars + ("\x26" + w + "\x3d" + g[w]) : w + "\x3d" + g[w];
                if (fa(e)) u = va(r, p, b), r.id == b && K(b, !0),
                    h.success = !0, h.ref = u; else {
                    if (f && za()) {
                        r.data = f;
                        xa(r, p, b, l);
                        return
                    }
                    K(b, !0)
                }
                l && l(h)
            })) : l && l(h)
        }, switchOffAutoHideShow: function () {
            Oa = !1
        }, ua: n, getFlashPlayerVersion: function () {
            return {major: n.pv[0], minor: n.pv[1], release: n.pv[2]}
        }, hasFlashPlayerVersion: fa, createSWF: function (a, b, c) {
            if (n.w3) return va(a, b, c)
        }, showExpressInstall: function (a, b, c, d) {
            n.w3 && za() && xa(a, b, c, d)
        }, removeSWF: function (a) {
            n.w3 && Qa(a)
        }, createCSS: function (a, b, c, d) {
            n.w3 && Pa(a, b, c, d)
        }, addDomLoadEvent: Ta, addLoadEvent: Sa, getQueryParamValue: function (a) {
            var b =
                t.location.search || t.location.hash;
            if (b) {
                /\?/.test(b) && (b = b.split("?")[1]);
                if (null == a) return Na(b);
                for (var b = b.split("\x26"), c = 0; c < b.length; c++) if (b[c].substring(0, b[c].indexOf("\x3d")) == a) return Na(b[c].substring(b[c].indexOf("\x3d") + 1))
            }
            return ""
        }, expressInstallCallback: function () {
            if (ha) {
                var a = F("SWFObjectExprInst");
                a && U && (a.parentNode.replaceChild(U, a), ia && (K(ia, !0), n.ie && n.win && (U.style.display = "block")), ya && ya(Ra));
                ha = !1
            }
        }
    };
    try {
        var v = window, C = v.document, Ia = v.globalStorage, xb = v.swfobject;
        try {
            var Ja =
                v.localStorage
        } catch (a) {
        }
        try {
            var Ka = v.sessionStorage
        } catch (a) {
        }
        var da, ta, db = {
            history: !1,
            java: !1,
            tests: 2,
            silverlight: !1,
            domain: Ca(v.location.host.split(":")[0]),
            baseurl: "",
            asseturi: "/assets",
            authPath: !1
        };
        v._evercookie_flash_var = function (a) {
            da = a;
            (a = C.getElementById("myswf")) && a.parentNode && a.parentNode.removeChild(a)
        };
        v.evercookie = v.Evercookie = function (a) {
            a = a || {};
            var b = {}, c;
            for (c in db) {
                var d = a[c];
                b[c] = "undefined" !== typeof d ? d : db[c]
            }
            "function" === typeof b.domain && (b.domain = b.domain(v));
            var e = b.tests,
                f = b.domain, g = this;
            this._ec = {};
            this.get = function (a, b, c) {
                g._evercookie(a, b, void 0, void 0, c)
            };
            this.set = function (a, b) {
                g._evercookie(a, function () {
                }, b)
            };
            this._evercookie = function (a, b, c, d, f) {
                void 0 === g._evercookie && (g = this);
                void 0 === d && (d = 0);
                0 === d && (g.evercookie_database_storage(a, c), g.evercookie_indexdb_storage(a, c), g._ec.userData = g.evercookie_userdata(a, c), g._ec.cookieData = g.evercookie_cookie(a, c), g._ec.localData = g.evercookie_local_storage(a, c), g._ec.globalData = g.evercookie_global_storage(a, c), g._ec.sessionData =
                    g.evercookie_session_storage(a, c));
                if (void 0 !== c) ("undefined" === typeof da || "undefined" === typeof ta) && d++ < e && setTimeout(function () {
                    g._evercookie(a, b, c, d, f)
                }, 300); else if ((v.openDatabase && "undefined" === typeof g._ec.dbData || ("indexedDB" in v || (v.indexedDB = v.indexedDB || v.mozIndexedDB || v.webkitIndexedDB || v.msIndexedDB)) && ("undefined" === typeof g._ec.idbData || "" === g._ec.idbData) || "undefined" === typeof da || "undefined" === typeof g._ec.etagData || "undefined" === typeof g._ec.cacheData || "undefined" === typeof g._ec.javaData ||
                        C.createElement("canvas").getContext && ("undefined" === typeof g._ec.pngData || "" === g._ec.pngData) || "undefined" === typeof ta) && d++ < e) setTimeout(function () {
                    g._evercookie(a, b, c, d, f)
                }, 20); else {
                    g._ec.lsoData = g.getFromStr(a, da);
                    da = void 0;
                    g._ec.slData = g.getFromStr(a, ta);
                    ta = void 0;
                    var r = g._ec, p = [], u = 0, k, h;
                    g._ec = {};
                    for (h in r) r[h] && "null" !== r[h] && "undefined" !== r[h] && (p[r[h]] = void 0 === p[r[h]] ? 1 : p[r[h]] + 1);
                    for (h in p) p[h] > u && (u = p[h], k = h);
                    void 0 === k || void 0 !== f && 1 === f || g.set(a, k);
                    "function" === typeof b && b(k, r)
                }
            };
            this.evercookie_window = function (a, b) {
                try {
                    if (void 0 !== b) {
                        var c;
                        var d = v.name;
                        if (-1 < d.indexOf("\x26" + a + "\x3d") || 0 === d.indexOf(a + "\x3d")) {
                            var e = d.indexOf("\x26" + a + "\x3d"), f;
                            -1 === e && (e = d.indexOf(a + "\x3d"));
                            f = d.indexOf("\x26", e + 1);
                            c = -1 !== f ? d.substr(0, e) + d.substr(f + (e ? 0 : 1)) + "\x26" + a + "\x3d" + b : d.substr(0, e) + "\x26" + a + "\x3d" + b
                        } else c = d + "\x26" + a + "\x3d" + b;
                        v.name = c
                    } else return this.getFromStr(a, v.name)
                } catch (yb) {
                }
            };
            this.evercookie_userdata = function (a, b) {
                try {
                    var c = this.createElem("div", "userdata_el", 1);
                    if (c.addBehavior) if (c.style.behavior =
                            "url(#default#userData)", void 0 !== b) c.setAttribute(a, b), c.save(a); else return c.load(a), c.getAttribute(a)
                } catch (w) {
                }
            };
            this.evercookie_local_storage = function (a, b) {
                try {
                    if (Ja) if (void 0 !== b) Ja.setItem(a, b); else return Ja.getItem(a)
                } catch (u) {
                }
            };
            this.evercookie_database_storage = function (a, b) {
                try {
                    if (v.openDatabase) {
                        var c = v.openDatabase("sqlite_evercookie", "", "evercookie", 1048576);
                        void 0 !== b ? c.transaction(function (c) {
                            c.executeSql("CREATE TABLE IF NOT EXISTS cache(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, value TEXT NOT NULL, UNIQUE (name))",
                                [], function () {
                                }, function () {
                                });
                            c.executeSql("INSERT OR REPLACE INTO cache(name, value) VALUES(?, ?)", [a, b], function () {
                            }, function () {
                            })
                        }) : c.transaction(function (b) {
                            b.executeSql("SELECT value FROM cache WHERE name\x3d?", [a], function (a, b) {
                                g._ec.dbData = 1 <= b.rows.length ? b.rows.item(0).value : ""
                            }, function () {
                            })
                        })
                    }
                } catch (w) {
                }
            };
            this.evercookie_indexdb_storage = function (a, b) {
                try {
                    if ("indexedDB" in v || (indexedDB = v.indexedDB || v.mozIndexedDB || v.webkitIndexedDB || v.msIndexedDB, IDBTransaction = v.IDBTransaction || v.webkitIDBTransaction ||
                            v.msIDBTransaction, IDBKeyRange = v.IDBKeyRange || v.webkitIDBKeyRange || v.msIDBKeyRange), indexedDB) {
                        var c = indexedDB.open("idb_evercookie", 1);
                        c.onerror = function () {
                        };
                        c.onupgradeneeded = function (a) {
                            a.target.result.createObjectStore("evercookie", {keyPath: "name", unique: !1})
                        };
                        c.onsuccess = void 0 !== b ? function (c) {
                            c = c.target.result;
                            c.objectStoreNames.contains("evercookie") && c.transaction(["evercookie"], "readwrite").objectStore("evercookie").put({
                                name: a,
                                value: b
                            });
                            c.close()
                        } : function (b) {
                            b = b.target.result;
                            if (b.objectStoreNames.contains("evercookie")) {
                                var c =
                                    b.transaction(["evercookie"]).objectStore("evercookie").get(a);
                                c.onsuccess = function () {
                                    g._ec.idbData = void 0 === c.result ? void 0 : c.result.value
                                }
                            } else g._ec.idbData = void 0;
                            b.close()
                        }
                    }
                } catch (w) {
                }
            };
            this.evercookie_session_storage = function (a, b) {
                try {
                    if (Ka) if (void 0 !== b) Ka.setItem(a, b); else return Ka.getItem(a)
                } catch (u) {
                }
            };
            this.evercookie_global_storage = function (a, b) {
                if (Ia) {
                    var c = this.getHost();
                    try {
                        if (void 0 !== b) Ia[c][a] = b; else return Ia[c][a]
                    } catch (w) {
                    }
                }
            };
            this.encode = function (a) {
                var b = "", c, d, e, f, g, r, h = 0;
                for (a =
                         this._utf8_encode(a); h < a.length;) c = a.charCodeAt(h++), d = a.charCodeAt(h++), e = a.charCodeAt(h++), f = c >> 2, c = (c & 3) << 4 | d >> 4, g = (d & 15) << 2 | e >> 6, r = e & 63, isNaN(d) ? g = r = 64 : isNaN(e) && (r = 64), b = b + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\x3d".charAt(f) + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\x3d".charAt(c) + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\x3d".charAt(g) + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\x3d".charAt(r);
                return b
            };
            this.decode = function (a) {
                var b = "", c, d, e, f, g, h = 0;
                for (a = a.replace(/[^A-Za-z0-9\+\/\=]/g, ""); h < a.length;) c = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\x3d".indexOf(a.charAt(h++)), d = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\x3d".indexOf(a.charAt(h++)), f = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\x3d".indexOf(a.charAt(h++)), g = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/\x3d".indexOf(a.charAt(h++)), c = c << 2 |
                    d >> 4, d = (d & 15) << 4 | f >> 2, e = (f & 3) << 6 | g, b += String.fromCharCode(c), 64 !== f && (b += String.fromCharCode(d)), 64 !== g && (b += String.fromCharCode(e));
                return b = this._utf8_decode(b)
            };
            this._utf8_encode = function (a) {
                a = a.replace(/\r\n/g, "\n");
                for (var b = "", c = 0, d = a.length, e; c < d; c++) e = a.charCodeAt(c), 128 > e ? b += String.fromCharCode(e) : (127 < e && 2048 > e ? b += String.fromCharCode(e >> 6 | 192) : (b += String.fromCharCode(e >> 12 | 224), b += String.fromCharCode(e >> 6 & 63 | 128)), b += String.fromCharCode(e & 63 | 128));
                return b
            };
            this._utf8_decode = function (a) {
                for (var b =
                    "", c = 0, d = a.length, e, f, g; c < d;) e = a.charCodeAt(c), 128 > e ? (b += String.fromCharCode(e), c += 1) : 191 < e && 224 > e ? (f = a.charCodeAt(c + 1), b += String.fromCharCode((e & 31) << 6 | f & 63), c += 2) : (f = a.charCodeAt(c + 1), g = a.charCodeAt(c + 2), b += String.fromCharCode((e & 15) << 12 | (f & 63) << 6 | g & 63), c += 3);
                return b
            };
            this.createElem = function (a, b, c) {
                a = void 0 !== b && C.getElementById(b) ? C.getElementById(b) : C.createElement(a);
                a.style.visibility = "hidden";
                a.style.position = "absolute";
                b && a.setAttribute("id", b);
                c && C.body.appendChild(a);
                return a
            };
            var k = this.waitForSwf =
                function (a) {
                    void 0 === a ? a = 0 : a++;
                    a < e && "undefined" === typeof xb && setTimeout(function () {
                        k(a)
                    }, 300)
                };
            this.evercookie_cookie = function (a, b) {
                if (void 0 !== b) C.cookie = a + "\x3d" + b + "; expires\x3dTue, 31 Dec 2030 00:00:00 UTC; path\x3d/; domain\x3d" + f; else return this.getFromStr(a, C.cookie)
            };
            this.getFromStr = function (a, b) {
                if ("string" === typeof b) {
                    var c = a + "\x3d", d = b.split(/[;&]/), e, f;
                    for (e = 0; e < d.length; e++) {
                        for (f = d[e]; " " === f.charAt(0);) f = f.substring(1, f.length);
                        if (0 === f.indexOf(c)) return f.substring(c.length, f.length)
                    }
                }
            };
            this.getHost = function () {
                return Ca(v.location.host.split(":")[0])
            };
            this.toHex = function (a) {
                for (var b = "", c = a.length, d = 0, e; d < c;) {
                    for (e = a.charCodeAt(d++).toString(16); 2 > e.length;) e = "0" + e;
                    b += e
                }
                return b
            };
            this.fromHex = function (a) {
                for (var b = "", c = a.length, d; 0 <= c;) d = c - 2, b = String.fromCharCode("0x" + a.substring(d, c)) + b, c = d;
                return b
            };
            var q = this.createElem("a", "_ec_rgb_link"), l, h;
            try {
                l = 1, h = C.createElement("style"), h.styleSheet ? h.styleSheet.innerHTML = "#_ec_rgb_link:visited{display:none;color:#FF0000}" : h.innerHTML ?
                    h.innerHTML = "#_ec_rgb_link:visited{display:none;color:#FF0000}" : h.appendChild(C.createTextNode("#_ec_rgb_link:visited{display:none;color:#FF0000}"))
            } catch (r) {
                l = 0
            }
            this._getRGB = function (a, b) {
                if (b && 0 === l) return -1;
                q.href = a;
                q.innerHTML = a;
                C.body.appendChild(h);
                C.body.appendChild(q);
                var c;
                if (C.defaultView) {
                    if (null == C.defaultView.getComputedStyle(q, null)) return -1;
                    c = C.defaultView.getComputedStyle(q, null).getPropertyValue("color")
                } else c = q.currentStyle.color;
                return c
            }
        }
    } catch (a) {
    }
    ea.prototype = {
        checkBroswer: function () {
            navigator.userAgent.toString().indexOf("MSIE")
        },
        checkOperaBroswer: function () {
            return window.opera
        }, getCanvansCode: function (a) {
            return new m("WAP" == Da() ? "wapSmartID" : "webSmartID", a)
        }, getUserAgent: function () {
            var a = navigator.userAgent, a = a.replace(/\&|\+/g, "");
            return new m("userAgent", a.toString())
        }, getScrHeight: function () {
            return new m("scrHeight", window.screen.height.toString())
        }, getScrWidth: function () {
            return new m("scrWidth", window.screen.width.toString())
        }, getScrAvailHeight: function () {
            return new m("scrAvailHeight", window.screen.availHeight.toString())
        },
        getScrAvailWidth: function () {
            return new m("scrAvailWidth", window.screen.availWidth.toString())
        }, md5ScrColorDepth: function () {
            return new m("scrColorDepth", window.screen.colorDepth.toString())
        }, getScrDeviceXDPI: function () {
            var a;
            a = "IE" == this.checkBroswer() ? window.screen.deviceXDPI.toString() : "";
            return new m("scrDeviceXDPI", a)
        }, getAppCodeName: function () {
            return new m("appCodeName", navigator.appCodeName.toString())
        }, getAppName: function () {
            return new m("appName", navigator.appName.toString())
        }, getJavaEnabled: function () {
            return new m("javaEnabled",
                navigator.javaEnabled() ? "1" : "0")
        }, getMimeTypes: function () {
            for (var a = navigator.mimeTypes, b = "", c = 0; c < a.length; c++) b += a[c].type + "#";
            return new m("mimeTypes", W(b.substr(0, b.length - 1)))
        }, getPlatform: function () {
            return new m("os", navigator.platform.toString())
        }, getAppMinorVersion: function () {
            var a;
            a = "IE" == this.checkBroswer() ? navigator.appMinorVersion.toString() : "";
            return new m("appMinorVersion", a)
        }, getBrowserLanguage: function () {
            var a;
            a = "IE" == this.checkBroswer() || this.checkOperaBroswer() ? navigator.browserLanguage.toString() :
                this.getLanguage();
            return new m("browserLanguage", a)
        }, getLanguage: function () {
            return null != navigator.language ? navigator.language.toString() : ""
        }, getCookieEnabled: function () {
            return new m("cookieEnabled", navigator.cookieEnabled ? "1" : "0")
        }, getCpuClass: function () {
            var a;
            a = "IE" == this.checkBroswer() ? navigator.cpuClass.toString() : "";
            return new m("cpuClass", a)
        }, getOnLine: function () {
            return new m("onLine", navigator.onLine.toString())
        }, getSystemLanguage: function () {
            var a;
            a = "IE" == this.checkBroswer() || this.checkOperaBroswer() ?
                navigator.systemLanguage.toString() : "";
            return new m("systemLanguage", a)
        }, getUserLanguage: function () {
            var a;
            a = "IE" == this.checkBroswer() || this.checkOperaBroswer() ? navigator.userLanguage.toString() : "";
            return new m("userLanguage", a)
        }, getTimeZone: function () {
            var a = (new Date).getTimezoneOffset() / 60;
            return new m("timeZone", a)
        }, getPlugins: function (a) {
            if ("IE" == this.checkBroswer()) return new m("plugins", W(a.replace(RegExp(",", "gm"), "#")));
            a = navigator.plugins;
            var b = "";
            for (i = 0; i < a.length; i++) b += a[i].name.toString() +
                "#";
            return new m("plugins", W(b))
        }, getFlashVersion: function () {
            var a = 0;
            if ("IE" == this.checkBroswer()) var b = new ActiveXObject("ShockwaveFlash.ShockwaveFlash"),
                a = Number(b.GetVariable("$version").split(" ")[1].replace(/,/g, ".").replace(/^(d+.d+).*$/, "$1")); else navigator.plugins && 0 < navigator.plugins.length && (b = navigator.plugins["Shockwave Flash"]) && (flashArr = b.description.split(" "), a = flashArr[2] + " " + flashArr[3]);
            return new m("flashVersion", a)
        }, getHistoryList: function () {
            return new m("historyList", window.history.length)
        },
        getSessionStorage: function (a) {
            return new m("sessionStorage", a)
        }, getLocalStorage: function (a) {
            return new m("localStorage", a)
        }, getIndexedDb: function (a) {
            return new m("indexedDb", a)
        }, getOpenDatabase: function (a) {
            return new m("openDatabase", a)
        }, getDoNotTrack: function (a) {
            return new m("doNotTrack", a)
        }, getAdblock: function (a) {
            return new m("adblock", a)
        }, getHasLiedLanguages: function (a) {
            return new m("hasLiedLanguages", a)
        }, getHasLiedResolution: function (a) {
            return new m("hasLiedResolution", a)
        }, getHasLiedOs: function (a) {
            return new m("hasLiedOs",
                a)
        }, getHasLiedBrowser: function (a) {
            return new m("hasLiedBrowser", a)
        }, getTouchSupport: function (a) {
            return new m("touchSupport", W(a.replace(RegExp(",", "gm"), "#")))
        }, getJsFonts: function (a) {
            return new m("jsFonts", W(a.replace(RegExp(",", "gm"), "#")))
        }, getCustId: function () {
            return new m("custID", "88")
        }, getUUID: function () {
            return "" == G("BSFIT_UUID") || null == G("BSFIT_UUID") || void 0 == G("BSFIT_UUID") ? new m("UUID", "new") : new m("UUID", G("BSFIT_UUID"))
        }, getSendPlatform: function () {
            return new m("platform", Da())
        }, getDfpMoreInfo: function (a) {
            var b =
                this;
            this.moreInfoArray = [];
            b.cfp.get(function (c, d) {
                b.moreInfoArray.push(b.getCanvansCode(c + ""));
                for (var e in d) {
                    c = d[e].key;
                    var f = d[e].value + "";
                    switch (c) {
                        case "session_storage":
                            b.moreInfoArray.push(b.getSessionStorage(f));
                            break;
                        case "local_storage":
                            b.moreInfoArray.push(b.getLocalStorage(f));
                            break;
                        case "indexed_db":
                            b.moreInfoArray.push(b.getIndexedDb(f));
                            break;
                        case "open_database":
                            b.moreInfoArray.push(b.getOpenDatabase(f));
                            break;
                        case "do_not_track":
                            b.moreInfoArray.push(b.getDoNotTrack(f));
                            break;
                        case "ie_plugins":
                            b.moreInfoArray.push(b.getPlugins(f));
                            break;
                        case "regular_plugins":
                            b.moreInfoArray.push(b.getPlugins());
                            break;
                        case "adblock":
                            b.moreInfoArray.push(b.getAdblock(f));
                            break;
                        case "has_lied_languages":
                            b.moreInfoArray.push(b.getHasLiedLanguages(f));
                            break;
                        case "has_lied_resolution":
                            b.moreInfoArray.push(b.getHasLiedResolution(f));
                            break;
                        case "has_lied_os":
                            b.moreInfoArray.push(b.getHasLiedOs(f));
                            break;
                        case "has_lied_browser":
                            b.moreInfoArray.push(b.getHasLiedBrowser(f));
                            break;
                        case "touch_support":
                            b.moreInfoArray.push(b.getTouchSupport(f));
                            break;
                        case "js_fonts":
                            b.moreInfoArray.push(b.getJsFonts(f))
                    }
                }
                "function" == typeof a && a()
            })
        }, getMachineCode: function () {
            return [this.getUUID(), this.getUserAgent(), this.getScrHeight(), this.getScrWidth(), this.getScrAvailHeight(), this.getScrAvailWidth(), this.md5ScrColorDepth(), this.getScrDeviceXDPI(), this.getAppCodeName(), this.getAppName(), this.getJavaEnabled(), this.getMimeTypes(), this.getPlatform(), this.getAppMinorVersion(), this.getBrowserLanguage(), this.getCookieEnabled(), this.getCpuClass(), this.getOnLine(),
                this.getSystemLanguage(), this.getUserLanguage(), this.getTimeZone(), this.getFlashVersion(), this.getHistoryList(), this.getCustId(), this.getSendPlatform()]
        }, getpackStr: function (a) {
            var b = [], b = [], b = this.getMachineCode(), b = b.concat(this.moreInfoArray);
            null != a && void 0 != a && "" != a && 32 == a.length && b.push(new m("cookieCode", a));
            a = {};
            for (var c = 0; c < b.length; c++) a[b[c].key] ? b.splice(c, 1) : a[b[c].key] = !0;
            b.sort(function (a, b) {
                var c, d;
                if ("object" === typeof a && "object" === typeof b && a && b) return c = a.key, d = b.key, c === d ? 0 : typeof c ===
                typeof d ? c < d ? -1 : 1 : typeof c < typeof d ? -1 : 1;
                throw"error";
            });
            return b
        }, NeedUpdate: function () {
            Q("fp_ver", "4.7.1", 0);
            Q("BSFIT_OKLJUJ", "", 0);
            return !1
        }, initEc: function (a) {
            var b = this, c = void 0 != a && void 0 != a.localAddr ? a.localAddr : "";
            this.ec.get("BSFIT_OkLJUJ", function (a) {
                b.getDfpMoreInfo(function () {
                    9E5 < G("BSFIT_EXPIRATION") - (new Date).getTime() & null != G("BSFIT_DEVICEID") & void 0 != G("BSFIT_DEVICEID") & !b.NeedUpdate() || b.expTimeEc.get("BSFIT_EXPIRATION", function (d) {
                        9E5 > d - (new Date).getTime() ? b.generateData(b, a, c) :
                            b.deviceEc.get("BSFIT_DEVICEID", function (d) {
                                null != d & void 0 != d ? b.verEc.get("fp_ver", function (d) {
                                    null != d & void 0 != d ? "4.7.1" != d && b.generateData(b, a, c) : b.generateData(b, a, c)
                                }) : b.generateData(b, a, c)
                            })
                    })
                })
            }, 1)
        }, generateData: function (a, b, c) {
            a.verEc.set("fp_ver", "4.7.1");
            var d = "", e = "", f = a.getpackStr(b);
            b = [];
            for (var g = [], k = [], q = [], l = 0; l < f.length; l++) "new" != f[l].value && -1 == jb.indexOf(f[l].key) && (-1 != kb.indexOf(f[l].key) ? g.push(f[l]) : -1 != lb.indexOf(f[l].key) ? k.push(f[l]) : -1 != mb.indexOf(f[l].key) ? q.push(f[l]) :
                b.push(f[l]));
            f = "";
            for (l = 0; l < g.length; l++) f = f + g[l].key.charAt(0) + g[l].value;
            g = "";
            for (l = 0; l < q.length; l++) g = 0 == l ? g + q[l].value : g + "x" + q[l].value;
            q = "";
            for (l = 0; l < k.length; l++) q = 0 == l ? q + k[l].value : q + "x" + k[l].value;
            b.push(new m("storeDb", f));
            b.push(new m("srcScreenSize", g));
            b.push(new m("scrAvailSize", q));
            "" != c && b.push(new m("localCode", ib(c)));
            c = a.ha(b, d, e);
            d = c.key;
            e = c.value;
            d += "\x26timestamp\x3d" + (new Date).getTime();
            Va.getJSON("http://dfp2.bangruitech.com/public/generate/jsonp" + ("?algID\x3dhUbuIzLVuK\x26hashCode\x3d" +
                e + d), null, function (b) {
                b = JSON.parse(b);
                for (var c in b) "dfp" == c ? G("BSFIT_DEVICEID") != b[c] && (Q("BSFIT_DEVICEID", b[c], 1E3), a.deviceEc.set("BSFIT_DEVICEID", b[c])) : "exp" == c ? (Q("BSFIT_EXPIRATION", (new Date).getTime() + Number(b[c]), 1E3), a.expTimeEc.set("BSFIT_EXPIRATION", (new Date).getTime() + Number(b[c]))) : "cookieCode" == c && (a.ec.set("BSFIT_OkLJUJ", b[c]), Q("BSFIT_OkLJUJ", "", 0))
            })
        }, ha: function (a, b, c) {
            for (var d = {}, e = 0; e < a.length; e++) d[a[e].key] ? a.splice(e, 1) : d[a[e].key] = !0;
            a.sort(function (a, b) {
                var c, d;
                if ("object" ===
                    typeof a && "object" === typeof b && a && b) return c = a.key, d = b.key, c === d ? 0 : typeof c === typeof d ? c < d ? -1 : 1 : typeof c < typeof d ? -1 : 1;
                throw"error";
            });
            for (d = 0; d < a.length; d++) {
                var e = a[d].key.replace(RegExp("%", "gm"), ""), f = "",
                    f = "string" == typeof a[d].value ? a[d].value.replace(RegExp("%", "gm"), "") : a[d].value;
                "" !== f && (c += e + f, f = encodeURIComponent(f), b += "\x26" + (void 0 == Wa[e] ? e : Wa[e]) + "\x3d" + f)
            }
            a = Ma(c);
            c = a.length;
            d = 0 == c % 3 ? parseInt(c / 3) : parseInt(c / 3) + 1;
            3 > c || (e = a.substring(0, 1 * d), f = a.substring(1 * d, 2 * d), a = a.substring(2 * d, c) +
                e + f);
            c = a.length;
            d = a.split("");
            for (e = 0; e < parseInt(c / 2); e++) 0 == e % 2 && (f = a.charAt(e), d[e] = d[c - 1 - e], d[c - 1 - e] = f);
            a = d.join("");
            a = Ma(a);
            c = "";
            d = a.length;
            for (e = 0; e < d; e++) f = a.charAt(e).charCodeAt(0), c = 127 === f ? c + String.fromCharCode(0) : c + String.fromCharCode(f + 1);
            c = X.SHA256(c).toString(X.enc.Base64);
            return new m(b, c)
        }, getFingerPrint: function () {
            var a = this;
            window.RTCPeerConnection || window.webkitRTCPeerConnection || window.mozRTCPeerConnection ? fb(function (b) {
                a.initEc(b)
            }) : a.initEc()
        }
    };
    var eb = !1;
    document.addEventListener ?
        document.addEventListener("DOMContentLoaded", function b() {
            document.removeEventListener("DOMContentLoaded", b, !1);
            La()
        }, !1) : document.attachEvent && document.attachEvent("onreadystatechange", function c() {
        eb || "interactive" != document.readyState && "complete" != document.readyState || (document.detachEvent("onreadystatechange", c), La(), eb = !0)
    })
})();