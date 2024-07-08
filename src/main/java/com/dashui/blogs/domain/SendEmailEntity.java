package com.dashui.blogs.domain;

import lombok.Data;
import org.thymeleaf.context.Context;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/22 20:11
 * @PackageName: com.dashui.blogs.mail.domain
 * @ClassName: BuildSendEmailEntity
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class SendEmailEntity {

    /**
     * 接收人
     */
    private String to;

    /**
     * 接收人
     */
    private String from;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String text;

    /**
     * 是否是html
     */
    private boolean isHtml;


    /**
     * template
     */
    private String template;

    /**
     * template
     */
    private Context context;


    public static final class SendEmailEntityBuilder {
        private String to;
        private String from;
        private String subject;
        private String text;
        private boolean isHtml;
        private String template;
        private Context context;

        private SendEmailEntityBuilder() {
        }

        public static SendEmailEntityBuilder aSendEmailEntity() {
            return new SendEmailEntityBuilder();
        }

        public SendEmailEntityBuilder withTo(String to) {
            this.to = to;
            return this;
        }

        public SendEmailEntityBuilder withFrom(String from) {
            this.from = from;
            return this;
        }

        public SendEmailEntityBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public SendEmailEntityBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public SendEmailEntityBuilder withIsHtml(boolean isHtml) {
            this.isHtml = isHtml;
            return this;
        }

        public SendEmailEntityBuilder withTemplate(String template) {
            this.template = template;
            return this;
        }

        public SendEmailEntityBuilder withContext(Context context) {
            this.context = context;
            return this;
        }

        public SendEmailEntity build() {
            SendEmailEntity sendEmailEntity = new SendEmailEntity();
            sendEmailEntity.setTo(to);
            sendEmailEntity.setFrom(from);
            sendEmailEntity.setSubject(subject);
            sendEmailEntity.setText(text);
            sendEmailEntity.setTemplate(template);
            sendEmailEntity.setContext(context);
            sendEmailEntity.isHtml = this.isHtml;
            return sendEmailEntity;
        }
    }
}
