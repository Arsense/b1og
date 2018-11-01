package com.halo.blog.domain;

import java.util.Date;

/**
 * @author tangwei
 * @date 2018/11/1 16:40
 */
public class BackFileVo {
    /**
     * 文件名
     */
    private String fileName;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 文件大小
     */
    private String fileSize;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 备份类型
     */
    private String backupType;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getBackupType() {
        return backupType;
    }

    public void setBackupType(String backupType) {
        this.backupType = backupType;
    }
}
