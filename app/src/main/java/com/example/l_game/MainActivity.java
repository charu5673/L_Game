package com.example.l_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout table,bottom_space,main,top_space;
    ImageButton ib00,ib01,ib02,ib03,ib10,ib11,ib12,ib13,ib20,ib21,ib22,ib23,ib30,ib31,ib32,ib33,tmp_b;
    Button red_b,blue_b,reset;
    int i,j,t=0,ig,jg,count=-1,c2=-1;
    int[][] st;
    int[] rb=new int[]{-1,-1,-1,-1};
    int[] g=new int[]{0,33,-1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        st=new int[][]{{1,2,2,0},{0,3,2,0},{0,3,2,0},{0,3,3,1}};
        table=findViewById(R.id.table);
        bottom_space=findViewById(R.id.bottom_space);
        main=findViewById(R.id.main);
        top_space=findViewById(R.id.top_space);
        red_b=findViewById(R.id.red_b);
        red_b.setOnClickListener(this);
        blue_b=findViewById(R.id.blue_b);
        blue_b.setOnClickListener(this);
        reset=findViewById(R.id.reset);
        reset.setOnClickListener(this);
        ib00=findViewById(R.id.ib00);
        ib00.setOnClickListener(this);
        ib01=findViewById(R.id.ib01);
        ib01.setOnClickListener(this);
        ib02=findViewById(R.id.ib02);
        ib02.setOnClickListener(this);
        ib03=findViewById(R.id.ib03);
        ib03.setOnClickListener(this);
        ib10=findViewById(R.id.ib10);
        ib10.setOnClickListener(this);
        ib11=findViewById(R.id.ib11);
        ib11.setOnClickListener(this);
        ib12=findViewById(R.id.ib12);
        ib12.setOnClickListener(this);
        ib13=findViewById(R.id.ib13);
        ib13.setOnClickListener(this);
        ib20=findViewById(R.id.ib20);
        ib20.setOnClickListener(this);
        ib21=findViewById(R.id.ib21);
        ib21.setOnClickListener(this);
        ib22=findViewById(R.id.ib22);
        ib22.setOnClickListener(this);
        ib23=findViewById(R.id.ib23);
        ib23.setOnClickListener(this);
        ib30=findViewById(R.id.ib30);
        ib30.setOnClickListener(this);
        ib31=findViewById(R.id.ib31);
        ib31.setOnClickListener(this);
        ib32=findViewById(R.id.ib32);
        ib32.setOnClickListener(this);
        ib33=findViewById(R.id.ib33);
        ib33.setOnClickListener(this);
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int h=table.getWidth();
        ViewGroup.LayoutParams params= table.getLayoutParams();
        params.height=h;
        table.setLayoutParams(params);
        int m=main.getHeight();
        params=top_space.getLayoutParams();
        params.height=2*(m-h)/5;
        top_space.setLayoutParams(params);
        params=bottom_space.getLayoutParams();
        params.height=3*(m-h)/5;
        bottom_space.setLayoutParams(params);
        h=(m-h)/2;
        red_b.setHeight(h/2);
        blue_b.setHeight(h/2);
    }

    @Override
    public void onClick(View v) {
        int x=v.getId();
        String text;
        if(x==R.id.blue_b||x==R.id.red_b||x==R.id.reset)
        {
            Button b=(Button)v;
            text=b.getText().toString();
        }
        else {
            ImageButton b=(ImageButton)v;
            text=(String)b.getTag();
        }
        if(text.equalsIgnoreCase("reset")||text.equalsIgnoreCase("Click to start"))
        {
            start();
            }
        else if(text.substring(0,text.length()-2).equals("ib"))
        {
            ImageButton b=(ImageButton)v;
            ig=Integer.valueOf(text.substring(2,3));
            jg=Integer.valueOf(text.substring(3));
            if(t!=0)
            {
                if(t==3)
                {
                    if(st[ig][jg]!=1&&st[ig][jg]!=2)
                    {
                        for(i=0;i<4;i++) {
                            if (rb[i] == ig * 10 + jg)
                                break;
                        }
                        if(i==4) {
                            highlight(b);
                            count++;
                            if (count == 4) {
                                tmp_b = findViewById(getIds("ib" + ((rb[0]<4)?("0"+rb[0]):rb[0])));
                                dehighlight(tmp_b, rb[0]);
                                for(i=0;i<3;i++)
                                {
                                    rb[i]=rb[i+1];
                                }
                                rb[3] = Integer.valueOf(((String) b.getTag()).substring(2));
                                count = 3;
                            } else
                                rb[count] = Integer.valueOf(((String) b.getTag()).substring(2));
                        }
                    }
                }
                else if(t==2)
                {
                    if(st[ig][jg]!=1&&st[ig][jg]!=3)
                    {
                        for(i=0;i<4;i++) {
                            if (rb[i] == ig * 10 + jg)
                                break;
                        }
                        if(i==4) {
                            highlight(b);
                            count++;
                            if (count == 4) {
                                tmp_b = findViewById(getIds("ib" + ((rb[0]<4)?("0"+rb[0]):rb[0])));
                                dehighlight(tmp_b, rb[0]);
                                for(i=0;i<3;i++)
                                {
                                    rb[i]=rb[i+1];
                                }
                                rb[3] = Integer.valueOf(((String) b.getTag()).substring(2));
                                count = 3;
                            } else
                                rb[count] = Integer.valueOf(((String) b.getTag()).substring(2));
                        }
                    }
                }
                else if(t==35||t==25)
                {
                    if(st[ig][jg]==1)
                    {
                        highlight(b);
                        int tmp=-1;
                        if(c2!=-1)
                        {
                            if(g[c2]==ig*10+jg) {
                                dehighlight(b, g[c2]);
                                tmp=c2;
                                c2=-1;
                            }
                            else {
                                dehighlight(findViewById(getIds("ib" + g[(c2 == 0) ? 0 : 1] / 10 + "" + g[(c2 == 0) ? 0 : 1] % 10)), g[(c2 == 0) ? 0 : 1]);
                                c2=(c2==0)?1:0;
                            }
                        }
                        else
                            c2=(g[0]==ig*10+jg)?0:1;
                        if(g[2]!=-1&&tmp!=-1)
                        {
                            tmp_b=findViewById(getIds("ib"+g[2]/10+""+g[2]%10));
                            dehighlight(tmp_b,g[2]);
                            g[2]=-1;
                        }
                    }
                    else if(st[ig][jg]==0&&c2!=-1)
                    {
                        if(g[2]!=ig*10+jg) {
                            highlight(b);
                            if (g[2] != -1) {
                                tmp_b = findViewById(getIds("ib" + g[2] / 10 + "" + g[2] % 10));
                                dehighlight(tmp_b, g[2]);
                            }
                            g[2] = ig * 10 + jg;
                        }
                        else {
                            dehighlight(b,g[2]);
                            g[2]=-1;
                        }
                    }
                }
            }
        }
        else if(text.substring(0,2).equalsIgnoreCase("re"))
        {
            if(t==3)
            {
                if(rb[3]!=-1)
                {
                    if(checkrb()) {
                        red_turn();
                        t = 35;
                        red_b.setText("RED\n----");
                        count = -1;
                        rb = new int[]{-1, -1, -1, -1};
                    }
                }
            }
            else if(t==35)
            {
                    turng();
                    t=2;
                    int fl=check(t);
                    if(fl==-1) {
                        win();
                        t = 1;
                    }
                    else {
                        blue_b.setText("BLUE\n====");
                        red_b.setText("RED\n");
                    }
            }
        }
        else if(text.substring(0,2).equalsIgnoreCase("bl"))
        {
            if(t==2)
            {
                if(rb[3]!=-1)
                {
                    if(checkrb()) {
                        blue_turn();
                        t = 25;
                        blue_b.setText("BLUE\n----");
                        count = -1;
                        rb = new int[]{-1, -1, -1, -1};
                    }
                }
            }
            else if(t==25)
            {
                    turng();
                    t=3;
                    int fl=check(t);
                    if(fl==-1) {
                        win();
                        t = 1;
                    }
                    else {
                        red_b.setText("RED\n====");
                        blue_b.setText("BLUE\n");
                    }
            }
        }
    }

    boolean checkrb() {
        int is[]=new int[4];
        int js[]=new int[4];
        for(j=0;j<4;j++)
        {
            is[j]=rb[j]/10;
            js[j]=rb[j]%10;
        }
        int x,y,z;
        for(x=0;x<=3;x++)
        {
            for(y=0;y<=3;y++)
            {
                if(y==x)
                    continue;
                for(z=0;z<=3;z++)
                {
                    if(z==y||z==x)
                        continue;
                    if(js[x]==js[y]&&js[y]==js[z]&&(js[6-x-y-z]==js[x]+1||js[6-x-y-z]==js[x]-1))
                    {
                        if(is[x]==is[y]-1&&is[y]==is[z]-1)
                        {
                            if(is[6-y-z-x]==is[z]||is[6-y-z-x]==is[x])
                                return true;
                        }
                        else if(is[x]==is[z]-1&&is[z]==is[y]-1)
                        {
                            if(is[6-y-z-x]==is[y]||is[6-y-z-x]==is[x])
                                return true;
                        }
                        else if(is[y]==is[x]-1&&is[x]==is[z]-1)
                        {
                            if(is[6-y-z-x]==is[z]||is[6-y-z-x]==is[y])
                                return true;
                        }
                        else if(is[y]==is[z]-1&&is[z]==is[x]-1)
                        {
                            if(is[6-y-z-x]==is[y]||is[6-y-z-x]==is[x])
                                return true;
                        }
                        else if(is[z]==is[y]-1&&is[y]==is[x]-1)
                        {
                            if(is[6-y-z-x]==is[z]||is[6-y-z-x]==is[x])
                                return true;
                        }
                        else if(is[z]==is[x]-1&&is[x]==is[y]-1)
                        {
                            if(is[6-y-z-x]==is[z]||is[6-y-z-x]==is[y])
                                return true;
                        }
                    }
                }
            }
        }
        for(x=0;x<=3;x++)
        {
            for(y=0;y<=3;y++)
            {
                if(y==x)
                    continue;
                for(z=0;z<=3;z++)
                {
                    if(z==y||z==x)
                        continue;
                    if(is[x]==is[y]&&is[y]==is[z]&&(is[6-x-y-z]==is[x]+1||is[6-x-y-z]==is[x]-1))
                    {
                        if(js[x]==js[y]-1&&js[y]==js[z]-1)
                        {
                            if(js[6-y-z-x]==js[z]||js[6-y-z-x]==js[x])
                                return true;
                        }
                        else if(js[x]==js[z]-1&&js[z]==js[y]-1)
                        {
                            if(js[6-y-z-x]==js[y]||js[6-y-z-x]==js[x])
                                return true;
                        }
                        else if(js[y]==js[x]-1&&js[x]==js[z]-1)
                        {
                            if(js[6-y-z-x]==js[z]||js[6-y-z-x]==js[y])
                                return true;
                        }
                        else if(js[y]==js[z]-1&&js[z]==js[x]-1)
                        {
                            if(js[6-y-z-x]==js[y]||js[6-y-z-x]==js[x])
                                return true;
                        }
                        else if(js[z]==js[y]-1&&js[y]==js[x]-1)
                        {
                            if(js[6-y-z-x]==js[z]||js[6-y-z-x]==js[x])
                                return true;
                        }
                        else if(js[z]==js[x]-1&&js[x]==js[y]-1)
                        {
                            if(js[6-y-z-x]==js[z]||js[6-y-z-x]==js[y])
                                return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    void turng() {
        if(c2!=-1&&g[2]!=-1)
        {
            tmp_b=findViewById(getIds("ib"+g[c2]/10+""+g[c2]%10));
            tmp_b.setImageResource(R.drawable.dark_white);
            tmp_b=findViewById(getIds("ib"+g[2]/10+""+g[2]%10));
            tmp_b.setImageResource(R.drawable.gray);
            st[g[c2]/10][g[c2]%10]=0;
            st[g[2]/10][g[2]%10]=1;
            g[c2]=g[2];
            c2=-1;
            g[2]=-1;
        }
    }

    void win() {
        if(t==2)
        red_b.setText("RED\nWins!");
        else blue_b.setText("BLUE\nWins!");
    }

    void start()
    {
        count=-1;
        c2=-1;
        reset.setText("Reset");
        t=3;
        rb= new int[]{-1, -1, -1, -1};
        g=new int[]{0,33,-1};
        st=new int[][]{{1,2,2,0},{0,3,2,0},{0,3,2,0},{0,3,3,1}};
        red_b.setText("RED\n====");
        blue_b.setText("BLUE\n");
        setGray(ib00);
        setGray(ib33);
        setBlue(ib01);
        setRed(ib32);
        for(i=1;i<=3;i++)
        {
            tmp_b=findViewById(getIds("ib"+i+"0"));
            setWhite(tmp_b);
        }
        for(i=0;i<=2;i++)
        {
            tmp_b=findViewById(getIds("ib"+i+"3"));
            setWhite(tmp_b);
        }
        for(i=1;i<=3;i++)
        {
            tmp_b=findViewById(getIds("ib"+i+"1"));
            setRed(tmp_b);
        }
        for(i=0;i<=2;i++)
        {
            tmp_b=findViewById(getIds("ib"+i+"2"));
            setBlue(tmp_b);
        }
    }
    void setGray(ImageButton b)
    {
        b.setImageResource(R.drawable.gray);
    }
    void setRed(ImageButton b)
    {
        b.setImageResource(R.drawable.red);
    }
    void setBlue(ImageButton b)
    {
        b.setImageResource(R.drawable.blue);
    }
    void setWhite(ImageButton b)
    {
        b.setImageResource(R.drawable.dark_white);
    }
    void highlight(ImageButton b)
    {
        if(t==25||t==35) {
            if(st[Integer.valueOf(((String)(b.getTag())).substring(2,3))][Integer.valueOf(((String)(b.getTag())).substring(3))]==1)
                b.setImageResource(R.drawable.gray_l);
            else
                b.setImageResource(R.drawable.gray_x);
        }
        else if(red_b.getText().charAt(red_b.getText().length()-1)=='=')
        {
            if(st[Integer.valueOf(((String)(b.getTag())).substring(2,3))][Integer.valueOf(((String)(b.getTag())).substring(3))]==3)
                b.setImageResource(R.drawable.red_x);
            else
                b.setImageResource(R.drawable.red_l);
        }
        else
        {
            if(st[Integer.valueOf(((String)(b.getTag())).substring(2,3))][Integer.valueOf(((String)(b.getTag())).substring(3))]==2)
                b.setImageResource(R.drawable.blue_x);
            else
                b.setImageResource(R.drawable.blue_l);
        }
    }
    void dehighlight(ImageButton b,int ij)
    {
        i=ij/10;
        j=ij%10;
        if(st[i][j]==2)
            b.setImageResource(R.drawable.blue);
        else if(st[i][j]==3)
            b.setImageResource(R.drawable.red);
        else if(st[i][j]==0)
            b.setImageResource(R.drawable.dark_white);
        else if(st[i][j]==1)
            b.setImageResource(R.drawable.gray);
    }
    void red_turn()
    {
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(st[i][j]==3)
                {
                    tmp_b=findViewById(getIds("ib"+i+""+j));
                    tmp_b.setImageResource(R.drawable.dark_white);
                    st[i][j]=0;
                }
            }
        }
        for(i=0;i<4;i++)
        {
            tmp_b=findViewById(getIds("ib"+((rb[i]<4)?("0"+rb[i]):rb[i])));
            tmp_b.setImageResource(R.drawable.red);
            st[rb[i]/10][rb[i]%10]=3;
        }
    }
    void blue_turn()
    {
        for(i=0;i<4;i++)
        {
            for(j=0;j<4;j++)
            {
                if(st[i][j]==2)
                {
                    tmp_b=findViewById(getIds("ib"+i+""+j));
                    tmp_b.setImageResource(R.drawable.dark_white);
                    st[i][j]=0;
                }
            }
        }
        for(i=0;i<4;i++)
        {
            tmp_b=findViewById(getIds("ib"+((rb[i]<4)?("0"+rb[i]):rb[i])));
            tmp_b.setImageResource(R.drawable.blue);
            st[rb[i]/10][rb[i]%10]=2;
        }
    }
    int check(int x)
    {
        int p,q,r;
        for(i=0;i<3;i++)
        {
            for(j=0;j<2;j++)
            {
                p=st[i][j];
                q=st[i][j+1];
                r=st[i][j+2];
                if(!((p==0||p==x)&&(q==0||q==x)&&(r==0||r==x)))
                {
                    p=st[i+1][j];
                    q=st[i+1][j+1];
                    r=st[i+1][j+2];
                    if(((p==0||p==x)&&(q==0||q==x)&&(r==0||r==x)))
                    {
                        p=st[i][j];
                        q=st[i][j+2];
                        if(p==0||q==0||p==x||r==x) {
                            if(st[i+1][j]==x&&st[i+1][j+1]==x&&st[i+1][j+2]==x)
                            {
                                if(!((st[i][j]==x&&(st[i][j+2]!=0&&st[i][j+2]!=x))||(st[i][j+2]==x&&(st[i][j]!=0&&st[i][j]!=x)))) {
                                    return (0);
                                }
                            }
                            else {
                                return (0);
                            }
                        }
                    }
                }
                else {
                    p = st[i + 1][j];
                    q = st[i + 1][j + 2];
                    if (p == 0 || q == 0 || p == x || q == x){
                        if(st[i][j]==x&&st[i][j+1]==x&&st[i][j+2]==x)
                        {
                            if(!((st[i+1][j]==x&&(st[i+1][j+2]!=0&&st[i+1][j+2]!=x))||(st[i+1][j+2]==x&&(st[i+1][j]!=0&&st[i+1][j]!=x)))) {
                                return (0);
                            }

                        }
                        else {
                            return (0);
                        }
                    }
                }
            }
        }
        for(i=0;i<2;i++)
        {
            for(j=0;j<3;j++)
            {
                p=st[i][j];
                q=st[i+1][j];
                r=st[i+2][j];
                if(!((p==0||p==x)&&(q==0||q==x)&&(r==0||r==x)))
                {
                    p=st[i][j+1];
                    q=st[i+1][j+1];
                    r=st[i+2][j+1];
                    if(((p==0||p==x)&&(q==0||q==x)&&(r==0||r==x)))
                    {
                        p=st[i][j];
                        q=st[i+2][j];
                        if(p==0||q==0||p==x||r==x){
                            if(st[i][j+1]==x&&st[i+1][j+1]==x&&st[i+2][j+1]==x)
                            {
                                if(!((st[i][j]==x&&(st[i+2][j]!=0&&st[i+2][j]!=x))||(st[i+2][j]==x&&(st[i][j]!=0&&st[i][j]!=x)))) {
                                    return (0);
                                }
                            }
                            else {
                                return (0);
                            }
                        }
                    }
                }
                else {
                    p = st[i][j + 1];
                    q = st[i + 2][j + 1];
                    if (p == 0 || q == 0 || p == x || q == x){
                        if(st[i][j]==x&&st[i+1][j]==x&&st[i+2][j]==x)
                        {
                            if(!((st[i][j+1]==x&&(st[i+2][j+1]!=0&&st[i+2][j+1]!=x))||(st[i+2][j+1]==x&&(st[i][j+1]!=0&&st[i][j+1]!=x)))) {
                                return (0);
                            }
                        }
                        else {
                            return (0);
                        }
                    }
                }
            }
        }
        return(-1);
    }
    void assignbbId(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    void assignbId(ImageButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    int getIds(String str)
    {
        str="R.id."+str;
        return(getResources().getIdentifier(str.replace("R.id.", ""), "id", getPackageName()));
    }
}