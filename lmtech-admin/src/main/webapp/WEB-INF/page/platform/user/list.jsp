<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/WEB-INF/tags/tags.tld" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../../common/header.jsp"/>

    <!--dynamic table-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/data-tables/DT_bootstrap.css"/>

    <script type="text/javascript">
        function edit(id) {
            top.showModal({
                url: "${pageContext.request.contextPath}/platform/user/edit.do?id=" + (id ? id : ""),
                title: !id ? "用户-添加" : "用户-编辑",
                opener: window,
                refreshOpener: false,
                width: 600,
                height: 500,
                onFinished: function (exeResult) {
                    $("form").submit();
                }
            });
        }
    </script>

</head>

<body class="body">

<div class="row">
    <div class="col-lg-12">
        <section class="panel">
            <form class="form-inline" action="${pageContext.request.contextPath}/platform/user/list.do" role="form"
                  method="post">
                <div class="adv-table">
                    <div class="row-fluid">
                        <div class="span3">
                            <div id="dynamic-table_length" class="dataTables_length">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="filter_LIKES_nickName"
                                           value="${filter_LIKES_nickName}" placeholder="请输入用户名">
                                </div>
                                <input type="submit" class="btn btn-primary" value="搜索"/>
                            </div>
                        </div>
                        <div class="span3">
                            <div class="dataTables_filter" id="dynamic-table_filter">
                                <a class="btn btn-primary" onclick="edit('');return false;">添加</a>
                            </div>
                        </div>
                    </div>

                    <table class="display table table-bordered" id="dynamic-table">
                        <thead>
                        <tr>
                            <th>姓名</th>
                            <th>邮箱</th>
                            <th>手机</th>
                            <th>QQ</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageData.items}" var="item">
                            <tr>
                                <td>${item.nickName}</td>
                                <td>${item.email}</td>
                                <td>${item.mobile}</td>
                                <td>${item.qq}</td>
                                <td>
                                    <div class="btn-group">
                                            <a class="btn btn-default btn-xs" onclick="edit('${item.id}');return false;">编辑</a>
                                            <a class="btn btn-default btn-xs"
                                               href="${pageContext.request.contextPath}/platform/urole/checklist.do?id=${item.id}&type=0">授权角色</a>
                                            <a href="javascript:listRemove('${pageContext.request.contextPath}/platform/user/remove.do?id=${item.id}')"
                                               class="btn btn-default btn-xs">删除</a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <h:pager pager="${pageData}"></h:pager>
                </div>
            </form>
        </section>
    </div>
</div>
</body>
</html>
