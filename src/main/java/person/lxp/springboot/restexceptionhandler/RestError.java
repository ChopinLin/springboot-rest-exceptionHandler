package person.lxp.springboot.restexceptionhandler;

import org.springframework.http.HttpStatus;

/**
 * Created by linxiaopeng on 2018-10-11.
 */
public class RestError {

    public static final String defaultErrorMesage = "default error message";
    public static final String defaultMoreInfo = "no more detail";
    public static final int defaultCode = 5000;
    public static final HttpStatus defaultStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    // http 状态
    private final HttpStatus status;
    // 扩展 http 状态码
    private final int code;
    // for user
    private final String message;
    // for developer，一般为exception 的 message
    private final String developerMessage;
    // 错误详细介绍
    private final String moreInfo;

    private RestError(HttpStatus status, int code, String message, String developerMessage, String moreInfo) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
        this.moreInfo = moreInfo;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestError restError = (RestError) o;

        if (code != restError.code) return false;
        if (status != restError.status) return false;
        if (message != null ? !message.equals(restError.message) : restError.message != null) return false;
        if (developerMessage != null ? !developerMessage.equals(restError.developerMessage) : restError.developerMessage != null)
            return false;
        return moreInfo != null ? moreInfo.equals(restError.moreInfo) : restError.moreInfo == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + code;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (developerMessage != null ? developerMessage.hashCode() : 0);
        result = 31 * result + (moreInfo != null ? moreInfo.hashCode() : 0);
        return result;
    }

    public static class Builder {

        private HttpStatus status = defaultStatus;
        private int code = defaultCode;
        private String message =defaultErrorMesage;
        private String developerMessage;
        private String moreInfo = defaultMoreInfo;

        public Builder() {
        }

        public Builder setStatus(int statusCode) {
            this.status = HttpStatus.valueOf(statusCode);
            return this;
        }

        public Builder setStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder setCode(int code) {
            this.code = code;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public Builder setMoreInfo(String moreInfo) {
            this.moreInfo = moreInfo;
            return this;
        }

        public RestError build() {
            return new RestError(this.status, this.code, this.message, this.developerMessage, this.moreInfo);
        }
    }
}
