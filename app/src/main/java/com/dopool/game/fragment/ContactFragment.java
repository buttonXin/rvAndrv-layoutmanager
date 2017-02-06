package com.dopool.game.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;

import com.dopool.game.R;
import com.dopool.game.adapter.MyAdapter;
import com.dopool.game.model.GameBean;
import com.dopool.game.ui.CardConfig;
import com.dopool.game.ui.CardLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/18 0018.
 */

public class ContactFragment extends BaseFragment {

    private RecyclerView mRv;
    private List<GameBean> mGameBeen = new ArrayList<>();

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.game_activity, null);

        mRv = (RecyclerView) view.findViewById(R.id.rv_game);
        CardLayoutManager manager1 = new CardLayoutManager();
        CardConfig.config(mActivity);
        mRv.setLayoutManager(manager1);

        return view ;
    }

    @Override
    public void initData() {
        addGame();
        final MyAdapter myAdapter= new MyAdapter(mGameBeen) ;
        mRv.setAdapter(myAdapter);
        ItemTouchHelper.Callback callback = new ItemTouchHelper.SimpleCallback(0 ,
                ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                GameBean remove = mGameBeen.remove(viewHolder.getLayoutPosition());
                mGameBeen.add(0 , remove);
                myAdapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mRv);

    }

    private List<String> mDatas= new ArrayList<>();

    private void addGame() {
        if (mDatas != null) {
            mDatas.clear();
        }
        initStringGame();

        for (int i = 0; i < mDatas.size(); i++) {
            mGameBeen.add(new GameBean("" , mDatas.get(i) ));
        }

    }

    private void initStringGame() {
        mDatas.add("  传牙签\n" +
                "　　参与游戏者每人抽一张扑克牌，然后相继按扑克牌的顺序坐好，持最小（或最大）的那张扑克牌的人为先头，用嘴衔住那根牙签，依次传到下一个人的嘴里，不许掉哦，注意不能借用手或任何工具帮忙，如果掉了，那自然要受到惩罚喽，传完一圈后，游戏未完。将牙签撅一半，继续抽扑克牌，按新的顺序坐好，接着下一轮的传递……继续撅一半……再撅……越玩越刺激……\n");

        mDatas.add("  偷天陷阱\n" +
                "　　记得电影偷天陷阱中辛康纳利训练泽塔琼斯过红外线的情景吗？\n" +
                "　　这个游戏有些类似，先制作道具找一些红绳（玻璃绳就行），中间穿上纸杯，来形容铃铛，还要准备眼罩根据参加人数，再准备背景音乐disco。让后请几个助手在舞台上拉着绳子，让参赛者先睁着眼睛练习一下，跟他们说这是一个非常有挑战性的游戏，要考验他们的灵巧度和记忆力，练习几次后，蒙上他们的眼睛，音乐响起，让他们走，这时候高潮是，主持人让所有的助手把绳子拿开，你就会看到很精彩的表演了，注意旁边的人还可以故意误导一下，说低头，抬脚等等\n");
        mDatas.add("  国王游戏\n" +
                "　　先是每个人分张数字.然后,抽出一人做国王,国王可以命令任何做事情,比如,1号和3号接吻.有时,是两个男的吻哈\n" +
                "　　接龙，第一个人说你好的好啊，第二个人说，你好的好啊，好漂亮的亮的亮阿，第三个人说你好的好啊，好漂亮的亮的亮啊，亮晶晶的晶阿\n");
        mDatas.add("  我爱你VS不要脸\n" +
                "　　听上去有些“暧昧”，实际上是个练反应的好游戏。\n" +
                "　　规则：众人围坐成一圈，规定只能对自己左边的人说“我爱你”，对右边的人说“不要脸”。两人之间只能连续对话3次。一旦有人说错，即受罚。\n" +
                "　　亮点：当游戏达到一定速度时，反应跟不上的人，往往会出现“我……不要脸”或“不……我爱你”之类的经典“自白”。\n");
        mDatas.add("  箩卜蹲\n" +
                "　　将参与者分成四堆以上，每堆人手牵着手围成一圈，给每堆人以颜色或数字命名，任意指定一堆萝卜开始统一下蹲，同时还要念词，再指定别的萝卜堆做同样动作，目标要一致，依此类推但不能马上回指。\n" +
                "　　以一实例加以说明。有红、白、黄、紫四堆萝卜，白萝卜先蹲，蹲的时候念“白萝卜蹲，白萝卜蹲，白萝卜蹲完红萝卜蹲。”念完后所有白萝卜手指一致指向红萝卜堆。红萝卜们马上要开始蹲且口中一样要念念有词，之后他们可以再指定下一个但不能是白萝卜。\n");
        mDatas.add("  两只小蜜蜂\n" +
                "　　念词：两只小蜜蜂呀，飞在花丛中呀，飞呀……\n" +
                "　　动作：两人面对面，1.两手作兰花指状展开双臂上下飞舞；2.两手换掌状于胸前交*飞舞；3.出手锤子剪刀布；4.赢者伸掌作摔巴掌状，口念\"啪啪\"；输者和声\"啊啊\"；不输不赢则同时努嘴作\"咋咋\"亲嘴状。\n" +
                "　　胜负：看反应速度，负者罚一节目。\n");
        mDatas.add("  一只青蛙\n" +
                "　　参与者围成一圈，面朝中央。主持人念“一”，顺时针下一位念“只”，再“青”再“蛙”再“跳”再“进”再“水”再“中”再“扑通”；接着“两只青蛙跳进水中扑通扑通”……依此类推，跟不上节奏或出错者罚节目。\n" +
                "　　\n" +
                "　　台上置三张椅子，邀请四个人上来，放DISCO音乐，四个人伴着音乐围着椅子转，当音乐骤停时抢坐椅子，未坐到者淘汰；减一椅子，三个人续前动作，当音乐骤停时抢坐两张椅子，未坐到者淘汰；最后两人抢坐一张椅子，坐到者为胜。\n");

        mDatas.add("  007\n" +
                "　　由开始一人发音\"零\"随声任指一人，那人随即亦发音\"零\"再任指另外一人，第三个人则发音\"柒\"，随声用手指作开枪状任指一人，\"中枪\"者不发音不作任何动作，但\"中枪\"者旁边左右两人则要发\"啊\"的声音，而扬手作投降状。――出错者饮！\n" +
                "　　（注：适合众人玩，由于没有轮流的次序，而是突发的任指其中的一个人，所以整个过程都必须处于紧张状态，因为可能下个就是你了！）\n");
        mDatas.add("  七、八、九\n" +
                "　　两粒骰子，一个骰盒，两人以上可玩，轮流摇骰，每人摇一次则立即开骰，如果尾数是7的则加酒，尾数是8的则喝一半，尾数是9的则要喝全杯，其他数目则过。轮流一人摇一次，可能你只能加酒却不会受罚喝酒，但也有可能你每次都要一个劲地喝酒，那就要看你的运气了。\n");
        mDatas.add("  大冒险\n" +
                "　　参与者每人抽取一张扑克牌，注意不要让其他人看到你的牌。由庄家指定拿到哪一张牌的人，来表演一个节目。节目一定要有趣，譬如要选中者到隔壁酒桌上要一杯酒，或者到舞台上向全场女士说\"我爱你们！\"，总之指定的节目越荒唐越刺激越好。下一轮，由表演节目的人来做庄家，继续抽牌。\n");
        mDatas.add("  真心话\n" +
                "　　规则和大冒险几乎相同，不同的是庄家指定的不是节目，而是要被选中的人回答一个问题。顾名思义，答案必须是真实的。当然，问题越刁钻越隐秘越有趣，但是要注意莫要侵犯人家隐私哟。\n");
        mDatas.add("  大瞎话\n" +
                "　　由一人蒙上眼睛扮\"瞎子\"，坐在\"瞎子\"左侧的人开始不断的指在座的每一个人。当他指向其中的人和一个人，就问\"瞎子\"，\"这个行不行？\"。\"瞎子\"如果说不行，就继续指下一个人。知道\"瞎子\"同意的时候，被指的那个人就是被游戏选中的人。\"瞎子\"摘下眼罩，根据每个人的表情来猜测谁被选中了，而参与的人不能告诉瞎子。当然，被选中的也可能是\"瞎子\"自己。瞎子要出一个题目或者说指定一个节目，要被选定的人去完成。和大冒险一样，节目越荒唐越刺激越好。\n" +
                "　　下一轮，由上一轮被选定人来做瞎子。\n");
        mDatas.add("  官兵捉贼\n" +
                "　　用具：分别写着\"官、兵、捉、贼\"字样的四张小纸\n" +
                "　　这个游戏最好是四个人来玩。将四张纸折叠起来，参加游戏的四个人分别抽出一张。抽到\"捉\"字的人要根据其他三个人的面部表情或其他细节来猜出谁拿的是\"贼\"字，猜错的要罚，有猜到\"官\"字的人决定如何惩罚，由抽到\"兵\"字的人执行。\n");
        mDatas.add("  蒙眼作画\n" +
                "　　所有学员用眼罩将眼睛蒙上，然后分发纸和笔，每人一份。要求蒙着眼睛将他们的家或者其他指定东西画在纸上。完成后，让学员摘下眼罩欣赏自己的大作。\n" +
                "　　让每个人在戴上眼罩前将他们的名字写在纸的另一面。在他们完成图画后，将所有的图片挂到墙上，让学员从中挑选出他们自己画的那幅。\n" +
                "　　教员用语言描述某一样东西，让学员蒙着眼睛画下他们所听到的，然后比较他们所画的图并思考，为何每个人听到是同样的描述，而画出的东西却是不同的，在工作时呢？（教具：眼罩，纸，笔）\n");
        mDatas.add("  循环相克令\n" +
                "　　用具：无\n" +
                "　　人数：两人\n" +
                "　　方法：令词为“猎人、狗熊、枪”，两人同时说令词，在说最后一个字的同时做出一个动作——猎人的动作是双手叉腰；狗熊的动作是双手搭在胸前；枪的动作是双手举起呈手枪状。双方以此动作判定输赢，猎人赢枪、枪赢狗熊、狗熊赢猎人，动作相同则重新开始。\n" +
                "　　兴奋点：这个游戏的乐趣在于双方的动作大，非常滑稽\n" +
                "　　缺点：只是两个人的游戏\n");
   /*     mDatas.add("  数7\n" +
                "　　这么古老的游戏！不过，既然旧瓶能装新酒，老游戏也能翻出新花样！\n" +
                "　　回顾一下老游戏的规则：首先人要多一点，5人以上。任意一人开始数数，1、2、3……那样数下去，逢到7的倍数（7、14、21……）和含有7的数字（17、27……）必须以敲桌子代替。如果有谁逢7却数出来了，就输，有谁没逢7就敲桌子的，也输。奉劝没有数字观念的人不要玩这个，很容易输的。\n" +
                "　　再看一下新花样：开头是一样的，但是，数到逢7的数字后，要倒回去数！比如，原来是顺时针数的，轮到甲是7，他敲一下桌子，照理坐在他左边的乙应该接下来数8，不是！现在要变成逆时针，由坐在他右边的丙数8！这样转来转去，我向你保证，转不了三次方向大伙儿就迷糊啦！\n" +
                "　　还有一点要说明：只有第一回是从1开始数的。接下来谁输了喝酒之后，由他开始数，可以不必从1开始，而是以小于10的任意数字开始。\n" +
                "　　试试看从6开始数……\n");
        */
       /* mDatas.add("  五毛和一块\n" +
                "　　道具：不需要；\n" +
                "　　场地：稍微宽敞一点就可以，没有特别要求；\n" +
                "　　人数：10几个人就可以，人多些更好玩的\n" +
                "　　人员：一定要有男有女，比例不限\n" +
                "　　裁判：一名，负责发号司令\n" +
                "　　规则如下：\n" +
                "　　在游戏中，男生就是一块钱，女生则是五毛钱。\n" +
                "　　游戏开始前，大家全站在一起，裁判站边上。裁判宣布游戏开始，并喊出一个钱数（比如3块5、6块或8快5这样的），裁判一旦喊出钱数，游戏中的人就要在最短的时间内组成那个数的小团队，打比方说喊出的是3块5，那就需要三男一女或七女或一男五女之类的小团队。请记住动作要快，因为资源是有限的，人员也很少有机会能平均分配，所以动作慢的同志可能会因为少几块或几毛钱而惨败，所以该出手时就出手，看见五毛(mm)先下手为强；当然动作快的人员不要一味的拉人，有可能裁判叫的是3块5，但你们团队里已经变成5块了，这时候你就需要踢人了，该狠心时就狠心，一般被无情踹出去的都是可怜的一块。\n" +
                "　　游戏要领：反应要快，裁判一说出来钱数，就要立刻知道分别由几男几女的团队可以达到要求；动作也要快，抢五毛和踢一块都要又快又狠\n");
*/


    }

}






