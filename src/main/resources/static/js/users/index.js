function goSearch(){
    $("#page").val(0);
    $("#form1").submit();
}

function goReset(flag){
    $('#form1 input,#form1  select').each(function e(){$(this).val('');});
    goSearch();
}

function goAction(flag, arg1, arg2) {
    var form = $('#form1');

    switch (flag) {
        /*목록*/
        case "L1":
            
            break;
        /*수정*/
        case "FU1":
            
            break;
        /*상세페이지 이동*/
        case "Q1":
            
            break;
        /*엑셀변환*/
        case "E1":
            
            break;
        /*삭제*/
        case "D1":
            modal.confirm("삭제하시겠습니까?", function () {
                $.post("/u183/A01D1.do", form.serialize(), function (result) {
                    if (result['resultCode'] == "FAIL") {
                        modal.alert(result['resultMessage']);
                        return false;
                    } else {
                        modal.alert(result['resultMessage'], function () {

                        });
                    }
                });
            });
            break;
        /*팝업*/
        case "P1":
            var buttons = {
                close: {
                    text: '닫기'
                    , btnClass: 'btn-secondary'
                },
                save: {
                    text: '저장'
                    , btnClass: 'btn-primary'
                    , action: function () {
                        var form = $('#form2');
                        modal.confirm("저장하시겠습니까?", function(){
                           $.post('/users/save',form.serialize(),function(res){
                               modal.alert("저장되었습니다.",function(){
                                   location.reload();
                               });
                           });
                        });
                        return false;
                    }
                }
            };
            modal.dialog("사용자 추가","url:/users/userFormPop?seq="+(arg1 ? arg1 : 0), buttons, "l");
    }
}