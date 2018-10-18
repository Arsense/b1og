<#compress >
<#include "module/_macro.ftl">
<@head>${options.blog_title} | 仪表盘</@head>
<div class="wrapper">
    <!-- 顶部栏模块 -->
    <#include "module/_header.ftl">
    <!-- 菜单栏模块 -->
    <#include "module/_sidebar.ftl">
    <div class="content-wrapper">
        <style type="text/css" rel="stylesheet">
            #btnWidgetsOption{margin-left:4px;padding:3px 6px;position:relative;top:-4px;border:1px solid #ccc;border-radius:2px;background:#fff;text-shadow:none;font-weight:600;font-size:12px;line-height:normal;color:#3c8dbc;cursor:pointer;transition:all .2s ease-in-out}
            #btnWidgetsOption:hover{background:#3c8dbc;color:#fff}
            .form-horizontal .control-label{
                text-align: left;
            }
            .control-radio{
                padding-top: 7px;
            }
        </style>
        <section class="content-header">
            <h1 style="display: inline-block;">仪表盘</h1>
            <a id="btnWidgetsOption" href="#">
                部件选项
            </a>
            <ol class="breadcrumb">
                <li>
                    <a href="/admin"><i class="fa fa-dashboard"></i>首页</a>
                </li>
                <li class="active">仪表盘</li>
            </ol>
        </section>
        <section class="content container-fluid">
            <!-- Small boxes (Stat box) -->
            <div class="row">
                <div class="col-lg-12 col-xs-12" id="widgetOptionsPanel" style="display: none">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">部件选项</h3>
                        </div>
                        <form class="form-horizontal" id="widgetsOption">
                            <div class="box-body">
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label for="widgetPostCount" class="col-sm-4 control-label">文章总数：</label>
                                        <div class="col-sm-8 control-radio">
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_postcount" id="widgetPostCount" value="true" ${((options.widget_postcount?default('true'))=='true')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>显示</label>
                                                </div>
                                            </div>
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_postcount" id="widgetPostCount" value="false" ${((options.widget_postcount?default('true'))=='false')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>隐藏</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="widgetCommentCount" class="col-sm-4 control-label">评论总数：</label>
                                        <div class="col-sm-8 control-radio">
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_commentcount" id="widgetCommentCount" value="true" ${((options.widget_commentcount?default('true'))=='true')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>显示</label>
                                                </div>
                                            </div>
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_commentcount" id="widgetCommentCount" value="false" ${((options.widget_commentcount?default('true'))=='false')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>隐藏</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="widgetAttachmentCount" class="col-sm-4 control-label">附件总数：</label>
                                        <div class="col-sm-8 control-radio">
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_attachmentcount" id="widgetAttachmentCount" value="true" ${((options.widget_attachmentcount?default('true'))=='true')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>显示</label>
                                                </div>
                                            </div>
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_attachmentcount" id="widgetAttachmentCount" value="false" ${((options.widget_attachmentcount?default('true'))=='false')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>隐藏</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="widgetDayCount" class="col-sm-4 control-label">成立天数：</label>
                                        <div class="col-sm-8 control-radio">
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_daycount" id="widgetDayCount" value="true" ${((options.widget_daycount?default('true'))=='true')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>显示</label>
                                                </div>
                                            </div>
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_daycount" id="widgetDayCount" value="false" ${((options.widget_daycount?default('true'))=='false')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>隐藏</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label for="widgetPostLastest" class="col-sm-4 control-label">最新文章：</label>
                                        <div class="col-sm-8 control-radio">
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_postlastest" id="widgetPostLastest" value="true" ${((options.widget_postlastest?default('true'))=='true')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>显示</label>
                                                </div>
                                            </div>
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_postlastest" id="widgetPostLastest" value="false" ${((options.widget_postlastest?default('true'))=='false')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>隐藏</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="widgetCommentLastest" class="col-sm-4 control-label">最新评论：</label>
                                        <div class="col-sm-8 control-radio">
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_commentlastest" id="widgetCommentLastest" value="true" ${((options.widget_commentlastest?default('true'))=='true')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>显示</label>
                                                </div>
                                            </div>
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_commentlastest" id="widgetCommentLastest" value="false" ${((options.widget_commentlastest?default('true'))=='false')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>隐藏</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="widgetLogsLastest" class="col-sm-4 control-label">最新日志：</label>
                                        <div class="col-sm-8 control-radio">
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_logslastest" id="widgetLogsLastest" value="true" ${((options.widget_logslastest?default('true'))=='true')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>显示</label>
                                                </div>
                                            </div>
                                            <div class="pretty p-default p-round">
                                                <input type="radio" name="widget_logslastest" id="widgetLogsLastest" value="false" ${((options.widget_logslastest?default('true'))=='false')?string('checked','')}>
                                                <div class="state p-primary">
                                                    <label>隐藏</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="button" class="btn btn-primary pull-right" onclick="saveOptions('widgetsOption')">保存</button>
                            </div>
                        </form>
                    </div>
                </div>
                <#if options.widget_postcount?default("true")=="true">
                <div class="col-lg-3 col-xs-6" id="widgetPostCountBody">
                    <div class="small-box bg-aqua">
                        <div class="inner"><h3><@articleTag method="postsCount">${postsCount?default(0)}</@articleTag></h3><p文章</p></div>
                        <div class="icon"><i class="ion ion-bag"></i></div>
                        <a data-pjax="true" href="/admin/posts" class="small-box-footer">查看所有 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                </#if>
                <#if options.widget_commentcount?default("true")=="true">
                <div class="col-lg-3 col-xs-6" id="widgetCommentCountBody">
                    <div class="small-box bg-green">
                        <div class="inner"><h3>${commentCount?default(0)}</h3><p>评论</p></div>
                        <div class="icon"><i class="ion ion-stats-bars"></i></div>
                        <a data-pjax="true" href="/admin/comments" class="small-box-footer">查看所有 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                </#if>
                <#if options.widget_attachmentcount?default("true")=="true">
                <div class="col-lg-3 col-xs-6" id="widgetAttachmentCountBody">
                    <div class="small-box bg-yellow">
                        <div class="inner"><h3>${mediaCount?default(0)}</h3><p>附件</p></div>
                        <div class="icon"><i class="ion ion-person-add"></i></div>
                        <a data-pjax="true" href="/admin/attachments" class="small-box-footer">上传图片 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
                </#if>
                <#if options.widget_daycount?default("true")=="true">
                <div class="col-lg-3 col-xs-6" id="widgetDayCountBody">
                    <div class="small-box bg-red">
                        <div class="inner"><h3 id="blogStart"></h3><p>成立天数</p></div>
                        <div class="icon"><i class="ion ion-pie-graph"></i></div>
                        <a href="#" class="small-box-footer" data-toggle="modal" data-target="#blogInfo">${options.blog_start?default('0000-00-00')} <i class="fa fa-star"></i></a>
                    </div>
                </div>
                </#if>
            </div>

            <div class="row">
                <#if options.widget_postlastest?default("true")=="true">
                <div class="col-lg-6 col-xs-12" id="widgetPostLastestBody">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">最新文章</h3>
                            <div class="box-tools">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
                                    <i class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="box-body table-responsive">
                            <table class="table table-bordered table-hover text-center">
                                <thead>
                                    <tr>
                                        <th width="50%">标题</th>
                                        <th>状态</th>
                                        <th>日期</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#if postTopFive??>
                                        <#list postTopFive as post>
                                            <tr>
                                                <#if post.postStatus == 0>
                                                    <td><a target="_blank" href="/archives/${post.postUrl}">${post.postTitle}</a></td>
                                                <#else >
                                                    <td>${post.postTitle}</td>
                                                </#if>
                                                <td class="text-center">
                                                    <#if post.postStatus==0>
                                                        <span class="label bg-green">已发布</span>
                                                    <#elseif post.postStatus==1>
                                                        <span class="label bg-yellow">草  稿</span>
                                                    <#else>
                                                        <span class="label bg-red">回收站</span>
                                                    </#if>
                                                </td>
                                                <td>${post.postDate?if_exists?string("yyyy-MM-dd HH:mm")}</td>
                                            </tr>
                                        </#list>
                                    <#else>
                                        <tr><td>暂无数据></td></tr>
                                    </#if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                </#if>
                <#if options.widget_commentlastest?default("true")=="true">
                <div class="col-lg-6 col-xs-12" id="widgetCommentLastestBody">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">最新评论</h3>
                            <div class="box-tools">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
                                    <i class="fa fa-minus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="box-body table-responsive">
                            <table class="table table-bordered table-hover text-center">
                                <thead>
                                <tr>
                                    <th>评论者</th>
                                    <th>评论页面</th>
                                    <th width="30%">内容</th>
                                    <th>状态</th>
                                    <th>日期</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <#--<#if comments??>-->
                                    <#--<#list comments as comment>-->
                                        <#--<tr>-->
                                            <#--<td>${comment.commentAuthor}</td>-->
                                            <#--<td>-->
                                                <#--<#if comment.post.postType=="post">-->
                                                    <#--<a target="_blank" href="/archives/${comment.post.getPostUrl()}">${comment.post.postTitle}</a>-->
                                                <#--<#else>-->
                                                    <#--<a target="_blank" href="/p/${comment.post.getPostUrl()}">${comment.post.postTitle}</a>-->
                                                <#--</#if>-->
                                            <#--</td>-->
                                            <#--<td>-->
                                                <#--<#switch comment.commentStatus>-->
                                                    <#--<#case 0>-->
                                                    <#--${comment.commentContent}-->
                                                    <#--<#break>-->
                                                    <#--<#case 1>-->
                                                    <#--${comment.commentContent}-->
                                                    <#--<#break>-->
                                                    <#--<#case 2>-->
                                                    <#--${comment.commentContent}-->
                                                    <#--<#break>-->
                                                <#--</#switch>-->
                                            <#--</td>-->
                                            <#--<td>-->
                                                <#--<#switch comment.commentStatus>-->
                                                <#--<#case 0>-->
                                                <#--<span class="label bg-green">已发布</span>-->
                                                <#--<#break >-->
                                                <#--<#case 1>-->
                                                <#--<span class="label bg-yellow">待审核/span>-->
                                                <#--<#break >-->
                                                <#--<#case 2>-->
                                                <#--<span class="label bg-red">回收站</span>-->
                                                <#--<#break >-->
                                                <#--</#switch>-->
                                            <#--</td>-->
                                            <#--<td>${comment.commentDate?string("yyyy-MM-dd HH:mm")}</td>-->
                                        <#--</tr>-->
                                    <#--</#list>-->
                                    <#--<#else>-->
                                        <#--<tr><td>暂无数据</td></tr>-->
                                    <#--</#if>-->
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                </#if>
                <#if options.widget_logslastest?default("true")=="true">
                <div class="col-lg-6 col-xs-12" id="widgetLogsLastestBody">
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">最新日志</h3>
                            <div class="box-tools">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-box-tool dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <i class="fa fa-bars"></i></button>
                                    <ul class="dropdown-menu pull-right" role="menu">
                                        <li><a href="#" onclick="openAllLogs()">查看所有</a></li>
                                        <li><a href="/admin/logs/clear"清空日志</a></li>
                                    </ul>
                                    <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip" title="Collapse">
                                        <i class="fa fa-minus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="box-body table-responsive">
                            <table class="table table-bordered table-hover text-center">
                                <thead>
                                    <tr>
                                        <th>事件</th>
                                        <th>结果</th>
                                        <th>IP</th>
                                        <th>日期</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <#if logs??>
                                    <#list logs as log>
                                        <tr>
                                            <td>${log.logTitle}</td>
                                            <td>${log.logContent}</td>
                                            <td>${log.logIp}</td>
                                            <td>${log.logCreated?string("yyyy-MM-dd HH:mm")}</td>
                                        </tr>
                                    </#list>
                                    <#else>
                                        <tr><td>暂无数据</td></tr>
                                    </#if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                </#if>
            </div>
        </section>
        <div class="modal fade" id="blogInfo" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="blog-data">博客数据</h4>
                    </div>
                    <#--<div class="modal-body">-->
                        <#--<p>「${options.blog_title?if_exists}」已经运行<span id="blogStartDay"></span><天了</p>-->
                        <#--<p>在此期间</p>-->
                        <#--<p>累计发表了&nbsp;<@articleTag method="postsCount">${postsCount?default(0)}</@articleTag>&nbsp;篇文章</p>-->
                        <#--<p>累计创建了&nbsp;<@commonTag method="tags">${tags?size}</@commonTag>&nbsp;个标签。</p>-->
                        <#--<p>累计获得了&nbsp;${commentCount}&nbsp;条评论。</p>-->
                        <#--<p>累计添加了&nbsp;<@commonTag method="links">${links?size}</@commonTag>&nbsp;个友链。</p>-->
                        <#--<p>文章总访问&nbsp;${postViewsSum?default(0L)}&nbsp;次。</p>-->
                        <#--<p>次。</p>-->
                    <#--</div>-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                    </div>
                </div>
            </div>
        </div>
        <script type="application/javascript">
            $(document).ready(function () {
                var dateBegin = new Date("${options.blog_start?default('0000-00-00')}");
                var dateEnd = new Date();
                var parseDate = dateEnd.getTime() - dateBegin.getTime();
                var days = Math.floor(parseDate/(24*3600*1000));
                $('#blogStart').html(days+1);
                $('#blogStartDay').html(days+1);
            });
            function openAllLogs() {
                layer.open({
                    type: 2,
                    title: '所有日志',
                    shadeClose: true,
                    shade: 0.5,
                    maxmin: true,
                    area: ['90%', '90%'],
                    content: '/admin/logs',
                    scrollbar: false
                });
            }
            $('#btnWidgetsOption').click(function () {
                $('#widgetOptionsPanel').slideToggle(400);
            });
        </script>
    </div>
    <#include "module/_footer.ftl">
</div>
<@footer></@footer>
</#compress>
