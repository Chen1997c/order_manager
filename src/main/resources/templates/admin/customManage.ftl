<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <#include "/public/common/head.ftl" >
    <title>『点餐系统』客户管理</title>
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
                                    <li class="am-active">客户管理</li>
                                </ol>
                            </div>


                        </div>
                        <div class="widget-body  am-fr">

                            <div class="am-margin-bottom-lg am-cf">
                                <div class="am-u-sm-12 am-u-md-6 am-u-lg-7">
                                    <span>客户列表</span>
                                </div>
                                <form id="search-user-form" class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                    <div class="am-form-group am-form-icon">
                                        <span class="am-icon-search"></span>
                                        <input type="text" name="c_name" class="am-form-field" placeholder="输入姓名搜索.."
                                               pattern="^\S{1,10}$">
                                    </div>
                                </form>
                                <div class="am-u-sm-12 am-u-md-12 am-u-lg-2 am-text-right">
                                    <button id="add" class="am-btn am-btn-success"
                                            data-am-modal="{target: '#custom-add-modal', closeViaDimmer: 0, width: 600, height: 390}">
                                        添加客户
                                    </button>
                                </div>
                            </div>

                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black "
                                       id="example-r">
                                    <thead>
                                    <tr>
                                        <th>客户id</th>
                                        <th>客户姓名</th>
                                        <th>性别</th>
                                        <th>用餐次数</th>
                                        <th>消费金额</th>
                                        <th>编辑</th>
                                        <th>删除</th>
                                    </tr>
                                    </thead>
                                <tbody>
                                    <#list customs.records as custom>
                                    <tr class="gradeX">
                                        <td id="id">${custom.c_id?c}</td>
                                        <td id="name">${custom.c_name}</td>
                                        <td id="sex">${custom.c_sex}</td>
                                        <td id="dinningTimes">${custom.c_dinningTimes}</td>
                                        <td id="dinningSum">${custom.c_dinningSum}</td>
                                        <input id="phoneNo" type="hidden" value="${custom.c_phoneNo}" >
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a class="edit-cInfo" href="javascript:;"
                                                   data-am-modal="{target: '#custom-edit-modal', closeViaDimmer: 0, width: 600, height: 630}">
                                                    <i class="am-icon-pencil"></i> 编辑
                                                </a>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;"
                                                   class="delete-custom tpl-table-black-operation-del">
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
                            <#if customs.pages gt 1>
                             <div class="am-u-lg-12 am-cf">
                                 <div class="am-fr">
                                     <ul class="am-pagination tpl-pagination">
                                         <li class="am-disabled">
                                             <a href="#">总页数:${customs.pages}</a>
                                         </li>
                                         <li class="am-disabled">
                                             <a href="#">当前页:${customs.current}</a>
                                         </li>
                                         <li class="page-tag am-active">
                                             <a href="?current=1<#if c_name??>&c_name=${c_name}</#if>">首页</a>
                                         </li>
                                         <li class="page-tag am-active">
                                             <a href="?current=${customs.current - 1}<#if c_name??>&c_name=${c_name}</#if>">上一页</a>
                                         </li>
                                         <li>
                                         <li class="page-tag am-active">
                                             <a href="?current=${customs.current + 1}<#if c_name??>&c_name=${c_name}</#if>">下一页</a>
                                         </li>
                                         <li class="page-tag am-active">
                                             <a href="?current=${customs.pages}<#if c_name??>&c_name=${c_name}</#if>">末页</a>
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
<#include "/admin/custom/edit.ftl">
<#include "/admin/custom/add.ftl">
<script src="${ctx}/js/amazeui.min.js"></script>
<script src="${ctx}/js/app.js"></script>
<script src="${ctx}/js/custom-edit.js"></script>
</body>

</html>