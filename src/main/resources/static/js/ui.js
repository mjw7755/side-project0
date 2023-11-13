$(document).ready(function(){

    // nav 메뉴 열고 닫기
    const btnMenu = $("header .btn_menu");
    const gnb = $("nav");
    btnMenu.click(function() {
        return [$(this).hasClass("fold") == true ? $(this).removeClass("fold") : $(this).addClass("fold"), $(gnb).hasClass("fold") == true ? $(gnb).removeClass("fold") : $(gnb).addClass("fold")];
    })

    // nav gnb 메뉴 알림 사전 설정
    const gnbAlertItem = $(".item_gnb:nth-child(3)");
    $(gnbAlertItem).addClass("alert");
    $(gnbAlertItem).find(".alert_num").addClass("on");
    $(gnbAlertItem).find(".list_sub:first .item_sub:nth-child(2), .list_sub:first .item_sub:nth-child(3)").addClass("alert");

    // 오른쪽 알림창
    const boxAlert = $(".box_alert");
    const boxAlertBtn = $(".box_alert .btn_open_alert");
    const boxAlertHeaderBtn = $(".tool_box .btn_alert");
    boxAlertBtn.click(function() {
        return $(boxAlert).hasClass("on") == true ? $(boxAlert).removeClass("on") : $(boxAlert).addClass("on");
    })

    boxAlertHeaderBtn.click(function() {
        return $(boxAlert).hasClass("on") == true ? $(boxAlert).removeClass("on") : $(boxAlert).addClass("on");
    })

    // 테이블 선택 시, on 클래스 추가하여 선택 표시
    const tableRow = $("table tr");

    tableRow.click(function(){
        $(this).addClass("on");
        tableRow.not($(this)).removeClass("on");
    })

    // 페이지네이션 선택 시, on 클래스 추가하여 선택 표시
    const pageLink = $(".pagenation .pages .link");

    pageLink.click(function(){
        $(this).addClass("on");
        pageLink.not($(this)).removeClass("on");
    })

    // 파일 추가 시, 파일 경로 출력
    var fileName = $("#file").val();
    $(".wrap_uio #file").on("change",function(){
        if(window.FileReader){
            var filename = $(this)[0].files[0].name;
        } else {
            var filename = $(this).val().split("/").pop().split("\\").pop();
        }
        $(this).siblings(".file_name").text(filename).css("color", "#333");
    });

    // 좁은 nav 시, 메뉴 확장 시 on 클래스 추가(hover 한계)
    $("nav .item_gnb").mouseover(function(){
        $(this).addClass("on");
    });

    $("nav .item_gnb").mouseleave(function(){
        $(this).removeClass("on");
    });

    // 알림 제거
    const alertItem = $(".item_alert");
    const alertItemRemoveBtn = $(".item_alert_close");
    const alertRemoveAllBtn = $(".btn_reset");
    alertItemRemoveBtn.click(function() {
        $(this).parent(alertItem).remove();
    })
    alertRemoveAllBtn.click(function() {
        $(this).siblings(".wrap_alert").find(alertItem).remove();
    })

 });