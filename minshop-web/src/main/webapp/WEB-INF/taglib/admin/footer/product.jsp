<%--
  Created by IntelliJ IDEA.
  User: DuyKyPaul
  Date: 9/23/2019
  Time: 12:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../../taglib.jsp" %>
<!-- basic scripts -->
<script src="<c:url value='/resources/assets/js/jquery-2.1.4.min.js'/>"></script>
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='<c:url value='/resources/assets/js/jquery.mobile.custom.min.js'/>'>" + "<" + "/script>");
</script>
<script src="<c:url value='/resources/assets/js/bootstrap.min.js'/>"></script>

<!-- page specific plugin scripts -->
<script src="<c:url value='/resources/assets/js/jquery.dataTables.min.js' />"></script>
<script src="<c:url value='/resources/assets/js/jquery.dataTables.bootstrap.min.js' />"></script>
<script src="<c:url value='/resources/assets/js/dataTables.buttons.min.js' />"></script>
<script src="<c:url value='/resources/assets/js/buttons.flash.min.js' />"></script>
<script src="<c:url value='/resources/assets/js/buttons.html5.min.js' />"></script>
<script src="<c:url value='/resources/assets/js/buttons.print.min.js' />"></script>
<script src="<c:url value='/resources/assets/js/buttons.colVis.min.js' />"></script>
<script src="<c:url value='/resources/assets/js/dataTables.select.min.js' />"></script>
<!-- ace scripts -->
<script src="<c:url value='/resources/assets/js/ace-elements.min.js'/>"></script>
<script src="<c:url value='/resources/assets/js/ace.min.js'/>"></script>
<%--twbsPagination--%>
<script src="<c:url value="/resources/js/jquery.twbsPagination.min.js" />"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    function deleteProductById(id, e) {
        showAlertBeforeDelete(function () {
            $.ajax({
                url: "/minshop/api/RemoveProducts",
                data: {
                    id: id
                }
            });
            e.path[4].remove();
        })
    };
    function updateProductById(id, e) {
        e.preventDefault();
        $.ajax({
            url: "/minshop/api/getProduct",
            data: {
                id: id
            }
        });
        window.location = "<c:url value='/admin/product-line/insert-product'/>";
    };
    $('body').on('click', '#update-test', function (e) {
        showAlertBeforeUpdatePrice(function () {
            $("#dynamic-table > tbody input:checked").each(function () {
                id = $(this).val();
                $.ajax({
                    url: "/minshop/api/UpdatePriceProduct",
                    data: {
                        id: id  
                    },
                    success: function (value) {
                        // alert(id + value);
                        if(value){
                            swal({
                                title: "Good job!",
                                text: "You clicked the button!",
                                confirmButtonText: "Oki",
                                confirmButtonClass: "btn btn-success"
                            }).then(function(isConfirm) {
                                if (isConfirm) {
                                    window.location = "<c:url value='/admin/product-line/1'/>";
                                }
                            })
                        } else {
                            swal({
                                title: "Not Good job!",
                                text: "You clicked the button!",
                                confirmButtonText: "Okiiiii",
                                confirmButtonClass: "btn btn-danger"
                            })
                        }

                    },
                    error: function () {
                        // alert(ids);
                    }
                });
            });

        });
    })
    $('body').on('click','#btn-search', function (e) {
        $('#pageNumber').val(1);
        $('#formUrl').submit();
    });
    $('#btn-clear').on('click', function (e) {
        $('#nameProduct').val("");
        $('#priceFrom').val("");
        $('#priceTo').val("");
        $('#maxResult').val(10);
        $('#pageNumber').val(1);
        $('#dynamic-table').DataTable().clear().draw();
    });
    jQuery(function ($) {
        //initiate dataTables plugin
        var myTable =
            $('#dynamic-table')
                .DataTable({
                    bAutoWidth: false,
                    "aoColumns": [
                        {"bSortable": false},
                        null, null, null, null, null,
                        {"bSortable": false}
                    ],
                    "aaSorting": [],
                    select: {
                        style: 'multi'
                    }
                });

        $.fn.dataTable.Buttons.defaults.dom.container.className = 'dt-buttons btn-overlap btn-group btn-overlap';

        new $.fn.dataTable.Buttons(myTable, {
            buttons: [
                {
                    "extend": "colvis",
                    "text": "<i class='fa fa-search bigger-110 blue'></i> <span class='hidden'>Show/hide columns</span>",
                    "className": "btn btn-white btn-primary btn-bold",
                    columns: ':not(:first):not(:last)'
                },
                {
                    "extend": "copy",
                    "text": "<i class='fa fa-copy bigger-110 pink'></i> <span class='hidden'>Copy to clipboard</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "csv",
                    "text": "<i class='fa fa-database bigger-110 orange'></i> <span class='hidden'>Export to CSV</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "excel",
                    "text": "<i class='fa fa-file-excel-o bigger-110 green'></i> <span class='hidden'>Export to Excel</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "pdf",
                    "text": "<i class='fa fa-file-pdf-o bigger-110 red'></i> <span class='hidden'>Export to PDF</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "extend": "print",
                    "text": "<i class='fa fa-print bigger-110 grey'></i> <span class='hidden'>Print</span>",
                    "className": "btn btn-white btn-primary btn-bold",
                    autoPrint: false,
                    message: 'This print was produced using the Print button for DataTables'
                },
                {
                    "text": "<i id='delete-product-multi' class='fa fa-trash-o bigger-110 orange'></i> <span class='hidden'>Delete</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                },
                {
                    "text": "<i id='insert-product' class='fa fa-plus-circle bigger-110 orange'></i> <span class='hidden'>Insert</span>",
                    "className": "btn btn-white btn-primary btn-bold"
                }
            ]
        });
        myTable.buttons().container().appendTo($('.tableTools-container'));

        //style the message box
        var defaultCopyAction = myTable.button(1).action();
        myTable.button(1).action(function (e, dt, button, config) {
            defaultCopyAction(e, dt, button, config);
            $('.dt-button-info').addClass('gritter-item-wrapper gritter-info gritter-center white');
        });


        var defaultColvisAction = myTable.button(0).action();
        myTable.button(0).action(function (e, dt, button, config) {

            defaultColvisAction(e, dt, button, config);


            if ($('.dt-button-collection > .dropdown-menu').length == 0) {
                $('.dt-button-collection')
                    .wrapInner('<ul class="dropdown-menu dropdown-light dropdown-caret dropdown-caret" />')
                    .find('a').attr('href', '#').wrap("<li />")
            }
            $('.dt-button-collection').appendTo('.tableTools-container .dt-buttons')
        });

        setTimeout(function () {
            $($('.tableTools-container')).find('a.dt-button').each(function () {
                var div = $(this).find(' > div').first();
                if (div.length == 1) div.tooltip({container: 'body', title: div.parent().text()});
                else $(this).tooltip({container: 'body', title: $(this).text()});
            });
        }, 500);


        myTable.on('select', function (e, dt, type, index) {
            if (type === 'row') {
                $(myTable.row(index).node()).find('input:checkbox').prop('checked', true);
            }
        });
        myTable.on('deselect', function (e, dt, type, index) {
            if (type === 'row') {
                $(myTable.row(index).node()).find('input:checkbox').prop('checked', false);
            }
        });


        /////////////////////////////////
        //table checkboxes
        $('th input[type=checkbox], td input[type=checkbox]').prop('checked', false);

        //select/deselect all rows according to table header checkbox
        $('#dynamic-table > thead > tr > th input[type=checkbox], #dynamic-table_wrapper input[type=checkbox]').eq(0).on('click', function () {
            var th_checked = this.checked;//checkbox inside "TH" table header

            $('#dynamic-table').find('tbody > tr').each(function () {
                var row = this;
                if (th_checked) myTable.row(row).select();
                else myTable.row(row).deselect();
            });
        });

        //select/deselect a row when the checkbox is checked/unchecked
        $('#dynamic-table').on('click', 'td input[type=checkbox]', function () {
            var row = $(this).closest('tr').get(0);
            if (this.checked) myTable.row(row).deselect();
            else myTable.row(row).select();
        });


        $(document).on('click', '#dynamic-table .dropdown-toggle', function (e) {
            e.stopImmediatePropagation();
            e.stopPropagation();
            e.preventDefault();
        });


        //And for the first simple table, which doesn't have TableTools or dataTables
        //select/deselect all rows according to table header checkbox
        var active_class = 'active';
        $('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function () {
            var th_checked = this.checked;//checkbox inside "TH" table header

            $(this).closest('table').find('tbody > tr').each(function () {
                var row = this;
                if (th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
                else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
            });
        });

        //select/deselect a row when the checkbox is checked/unchecked
        $('#simple-table').on('click', 'td input[type=checkbox]', function () {
            var $row = $(this).closest('tr');
            if ($row.is('.detail-row ')) return;
            if (this.checked) $row.addClass(active_class);
            else $row.removeClass(active_class);
        });


        /********************************/
        //add tooltip for small view action buttons in dropdown menu
        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

        //tooltip placement on right or left
        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table');
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            //var w2 = $source.width();

            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
            return 'left';
        }

        /***************/
        $('.show-details-btn').on('click', function (e) {
            e.preventDefault();
            $(this).closest('tr').next().toggleClass('open');
            $(this).find(ace.vars['.icon']).toggleClass('fa-angle-double-down').toggleClass('fa-angle-double-up');
        });



        $('#delete-product-multi').on('click', function () {
            showAlertBeforeDelete(function () {
                var id = 0;
                $("#dynamic-table > tbody input:checked").each(function () {
                    id = $(this).val();
                    $.ajax({
                        url: "/minshop/api/RemoveProducts",
                        data: {
                            id: id
                        },
                        success: function (value) {
                            // alert(id);
                        },
                        error: function () {
                            // alert(ids);
                        }
                    });
                    $("#dynamic-table > tbody input:checked").each(function () {
                        $(this).closest("tr").remove();
                    });
                });
            });
        });
        $('#insert-product').on('click', function (e) {
            e.preventDefault();
            $.ajax({
                url: "/minshop/api/RemoveProductSession"
            });
            window.location = "<c:url value='/admin/product-line/insert-product'/>";
        });
        $('.price-test').css('color', 'red');

        // $('#display-result').change(function() {
        //     $('#maxResult').val($(this).val());
        // });

        // $('body').on('click', '.page-item', function (e) {
        //     e.preventDefault();
        //     var maxResult = $('#display-result');
        //     if($(this).text().trim() === "Next") {
        //         $('#pageNumber').val($('.pagination .active').next().eq(1).text());
        //     } else if($(this).text().trim() === "Previous"){
        //         $('#pageNumber').val($('.pagination .active').prev().eq(1).text());
        //     } else {
        //         $('#pageNumber').val($(this).text());
        //     }
        //     // console.log($('#display-result').value);
        //     $('#formUrl').submit();
        // });
    })
</script>
