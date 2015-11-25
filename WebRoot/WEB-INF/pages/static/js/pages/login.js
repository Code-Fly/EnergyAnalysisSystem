'use strict';

var BootstrapButton = React.createClass({
    render: function () {
        return (
            <a {...this.props}
                href="javascript:;"
                role="button"
                className={(this.props.className || '') + ' btn'}/>
        );
    }
});

var BootstrapInput = React.createClass({
    render: function () {
        return (
            <input {...this.props}
                className={(this.props.className || '') + ' form-control'}/>
        );
    }
});

var LoginForm = React.createClass({
    handleLoginFormSubmit: function (e) {
        var userName = this.state.userName;
        var password = this.state.password;
        //$(e.target).addClass("disabled");
        var cur = this;
        cur.setState({
            disableBtn: "disabled",
        });

        $.ajax({
            url: _ctx + "/api/login/query?opNm=" + userName + "&opPwd=" + password,
            cache: false,
            success: function (data, textStatus, jqXHR) {
                if ("" != data && null != data) {
                    SessionCache.update("opID", data);
                    SessionCache.update("userName", userName);
                    window.location.href = _ctx + "/web/index";
                } else {
                    SessionCache.remove("opID");
                    SessionCache.remove("userName");
                    alert("认证失败");
                    //$(e.target).removeClass("disabled");
                    cur.setState({
                        disableBtn: null,
                    });
                }

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                SessionCache.remove("opID");
                SessionCache.remove("userName");
                alert("认证异常");
                //$(e.target).removeClass("disabled");
                cur.setState({
                    disableBtn: null,
                });
            }
        });
    },
    getInitialState: function () {
        return {
            userName: null,
            password: null,
            disableBtn: null
    }
    },
    handleUserName: function (e) {
        var value = e.target.value;
        this.setState({
            userName: value,
        });
    },
    handlePassword: function (e) {
        var value = e.target.value;
        this.setState({
            password: value,
        });
    },

    render: function () {

        return (
            <div className="row">
                <div className="col-md-4 col-md-offset-4">
                    <div className="login-panel panel panel-default">
                        <div className="panel-heading">
                            <h3 className="panel-title">请登陆</h3>
                        </div>
                        <div className="panel-body">
                            <form role="form">
                                <fieldset>
                                    <div className="form-group">
                                        <BootstrapInput key="userName" placeholder="用户名" name="userName"
                                                        type="text"
                                                        autofocus="true" onChange={this.handleUserName}
                                        />
                                    </div>
                                    <div className="form-group" ref="test">
                                        <BootstrapInput key="password" placeholder="密码" name="password"
                                                        type="password" onChange={this.handlePassword}/>
                                    </div>
                                    <BootstrapButton ref="loginBtn"
                                                     className={"btn-lg btn-success btn-block " + (this.state.disableBtn)}
                                                     onClick={this.handleLoginFormSubmit}>登陆</BootstrapButton>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
});

ReactDOM.render(
    <LoginForm />, document.getElementById('container')
);