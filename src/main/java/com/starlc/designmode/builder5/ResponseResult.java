//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package com.starlc.designmode.builder5;
import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -5734417299472900553L;
    private Long errcode;
    private String errmsg;
    private T data;

    ResponseResult(final Long errcode, final String errmsg, final T data) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
    }

    public static <T> ResponseResult.ResponseResultBuilder<T> builder() {
        return new ResponseResult.ResponseResultBuilder();
    }

    public Long getErrcode() {
        return this.errcode;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public T getData() {
        return this.data;
    }

    public void setErrcode(final Long errcode) {
        this.errcode = errcode;
    }

    public void setErrmsg(final String errmsg) {
        this.errmsg = errmsg;
    }

    public void setData(final T data) {
        this.data = data;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseResult)) {
            return false;
        } else {
            ResponseResult<?> other = (ResponseResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$errcode = this.getErrcode();
                    Object other$errcode = other.getErrcode();
                    if (this$errcode == null) {
                        if (other$errcode == null) {
                            break label47;
                        }
                    } else if (this$errcode.equals(other$errcode)) {
                        break label47;
                    }

                    return false;
                }

                Object this$errmsg = this.getErrmsg();
                Object other$errmsg = other.getErrmsg();
                if (this$errmsg == null) {
                    if (other$errmsg != null) {
                        return false;
                    }
                } else if (!this$errmsg.equals(other$errmsg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ResponseResult;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $errcode = this.getErrcode();
        result = result * 59 + ($errcode == null ? 43 : $errcode.hashCode());
        Object $errmsg = this.getErrmsg();
        result = result * 59 + ($errmsg == null ? 43 : $errmsg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResponseResult(errcode=" + this.getErrcode() + ", errmsg=" + this.getErrmsg() + ", data=" + this.getData() + ")";
    }

    public static class ResponseResultBuilder<T> {
        private Long errcode;
        private String errmsg;
        private T data;

        ResponseResultBuilder() {
        }

        public ResponseResult.ResponseResultBuilder<T> errcode(final Long errcode) {
            this.errcode = errcode;
            return this;
        }

        public ResponseResult.ResponseResultBuilder<T> errmsg(final String errmsg) {
            this.errmsg = errmsg;
            return this;
        }

        public ResponseResult.ResponseResultBuilder<T> data(final T data) {
            this.data = data;
            return this;
        }

        public ResponseResult<T> build() {
            return new ResponseResult(this.errcode, this.errmsg, this.data);
        }

        @Override
        public String toString() {
            return "ResponseResult.ResponseResultBuilder(errcode=" + this.errcode + ", errmsg=" + this.errmsg + ", data=" + this.data + ")";
        }
    }
}
