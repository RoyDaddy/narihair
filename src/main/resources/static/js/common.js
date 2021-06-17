$(function(){
    $(".date").datepicker({
        format: "yyyy-mm-dd",
        language: "ko",
        orientation: "bottom left",
        autoclose: true,
        todayHighlight: true
    });
});

var modal = {
    alert: function (message, callback) {

        var options = {
            title: '알림'
            , content: message
            , closeIcon: false
            , buttons: {
                ok: {
                    text: '닫기'
                    , btnClass:'btn-other btn-close'
                }
            }
        };

        if (callback && $.isFunction(callback)) {
            options.buttons.ok.action = callback;
            $.confirm(options);
        } else {
            $.alert(options);
        }
    },
    confirm: function (message, callback) {

        var options = {
            title: '확인'
            , content: message
            , buttons: {
                close: {
                    text: '아니요'
                    , btnClass:'btn-secondary'
                },
                ok: {
                    text: '예'
                    , btnClass:'btn-primary'
                }
            }
        };

        if (callback && $.isFunction(callback)) {
            options.buttons.ok.action = callback;
        }

        if (arguments[2] && $.isFunction(arguments[2])) {
            options.buttons.close.action = arguments[2];
        }

        $.confirm(options);
    },
    dialog: function (title, content, buttons, width) {
        //width가 지정되어 있지 않을 경우 기본사이즈 고정
        if(width == '' || width == undefined){
            width = 'm';
        }

        var options = {
            title: title
            , content: content
            , columnClass: width
            , buttons: {
                close: {
                    text: '닫기'
                    , btnClass:'btn-other btn-close'
                }
            }
        };

        if (buttons) options.buttons = buttons;

        options.onContentReady = function () {
            if (content.indexOf('iframe') !== -1) {
                this.$el.addClass('pop_margin_control');
                options.autoResize = true;
            }
            $(window).unbind('resize.' + this._id);
            $('.jconfirm').css('z-index', '10000');
            $('.jconfirm-holder').css('overflow', 'auto');
        };

        return $.confirm(options);
    },
    close: function () {
        jconfirm.instances.pop().close();
    }
};