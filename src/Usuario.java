public class Usuario {
    private String user_id;
    private static Usuario _this;

    private Usuario(){
    }

    public static Usuario getInstance(){
        if(_this == null)
            _this= new Usuario();
        return _this;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

}
