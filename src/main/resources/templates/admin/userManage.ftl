<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#include "/public/common/head.ftl" >
    <title>『点餐系统』员工管理</title>
</head>

<body data-type="widgets">
<script src="${ctx}/js/theme.js"></script>

<div class="am-g tpl-g">
    <#include "/public/common/head-bar.ftl">
    <#include "/admin/common/side-bar.ftl">

    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">
                                <ol class="am-breadcrumb breadcrumb-self">
                                    <li>
                                        <a href="#">首页</a>
                                    </li>
                                    <li class="am-active">员工管理</li>
                                </ol>
                            </div>


                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-margin-bottom-lg am-cf">
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-7">
                                    <span>员工列表</span>
                                </div>
                                <form id="search-user-form" class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                    <div class="am-form-group am-form-icon">
                                        <span class="am-icon-search"></span>
                                        <input type="text" name="u_name" class="am-form-field" placeholder="输入姓名搜索.."
                                               pattern="^\S{1,10}$">
                                    </div>
                                </form>
                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-2 am-text-right">
                                    <button id="add" class="am-btn am-btn-success"
                                            data-am-modal="{target: '#user-add-modal', closeViaDimmer: 0, width: 600, height: 520}">
                                        添加员工
                                    </button>
                                </div>
                            </div>

                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black "
                                       id="example-r">
                                    <thead>
                                    <tr>
                                        <th>员工id</th>
                                        <th>员工帐号</th>
                                        <th>员工职务</th>
                                        <th>查看</th>
                                        <th>编辑</th>
                                        <th>删除</th>
                                    </tr>
                                    </thead>
                                <tbody>
                                    <#list users.records as user>
                                    <tr class="gradeX">
                                        <td id="id">${user.u_id?c}</td>
                                        <td>${user.u_account}</td>
                                        <td>${user.userPosition.position}</td>
                                        <input id="account" type="hidden" value="${user.u_account}">
                                        <input id="position" type="hidden" value="${user.userPosition.position}">
                                        <input id="name" type="hidden" value="${user.u_name}">
                                        <input id="sex" type="hidden" value="${user.u_sex}">
                                        <input id="phoneNo" type="hidden" value="${user.u_phoneNo}">
                                        <input id="address" type="hidden" value="${user.u_address!}">
                                        <input id="isLocked" type="hidden" value="${user.u_isLocked!}">
                                        <input id="faceImg" type="hidden" value="${ctx}${user.u_faceImg!}">
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a class="see-eInfo" href="javascript:;"
                                                   data-am-modal="{target: '#user-info-modal', closeViaDimmer: 0, width: 400, height: 500}">
                                                    <i class="am-icon-search"></i> 查看
                                                </a>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a class="edit-eInfo" href="javascript:;"
                                                   data-am-modal="{target: '#user-edit-modal', closeViaDimmer: 0, width: 600, height: 520}">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;"
                                                   class="delete-user tpl-table-black-operation-del">
                                                    <i class="am-icon-trash"></i> 删除
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <!-- more data -->
                                    </tbody>
                                    </#list>
                                </table>
                            </div>
                            <#if users.pages gt 1>
                             <div class="am-u-lg-12 am-cf">
                                 <div class="am-fr">
                                     <ul class="am-pagination tpl-pagination">
                                         <li class="am-disabled">
                                             <a href="#">总页数:${users.pages}</a>
                                         </li>
                                         <li class="am-disabled">
                                             <a href="#">当前页:${users.current}</a>
                                         </li>
                                         <li class="page-tag am-active">
                                             <a href="?current=1<#if u_name??>&u_name=${u_name}</#if>">首页</a>
                                         </li>
                                         <li class="page-tag am-active">
                                             <a href="?current=${users.current - 1}<#if u_name??>&u_name=${u_name}</#if>">上一页</a>
                                         </li>
                                         <li>
                                         <li class="page-tag am-active">
                                             <a href="?current=${users.current + 1}<#if u_name??>&u_name=${u_name}</#if>">下一页</a>
                                         </li>
                                         <li class="page-tag am-active">
                                             <a href="?current=${users.pages}<#if u_name??>&u_name=${u_name}</#if>">末页</a>
                                         </li>
                                     </ul>
                                 </div>
                             </div>
                            </#if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<#include "/admin/user/info.ftl" >
<#include "/admin/user/edit.ftl" >
<#include "/admin/user/add.ftl" >
<script src="${ctx}/js/amazeui.min.js"></script>
<script src="${ctx}/js/app.js"></script>
<script src="${ctx}/js/user-edit.js"></script>
</body>

</html>