/**
 * 新增节点后的修复操作
 * x 表示新增节点
 */
public class Main {
    private void fixAfterInsertion(Entry<K, V> x) {
        x.color = RED; //新增节点的颜色为红色

        //循环 直到x不是根节点，且x的父节点不为红色
        while (x != null && x != root && x.parent.color == RED) {
            //如果x的父节点 （p）是其父节点的父节点G 的左节点
            if (parentOf(x) == leftOf(parentOf(parentOf(x)))) {
                //获取x的叔节点 U
                Entry<K, V> y = rightOf(parentOf(parentOf(x)));
                //如果X的叔节点U 为红色 （情况三）
                if (colorOf(y) == RED) {
                    //将X的父节点 P 设置为黑色
                    setColor(parentOf(x), BLACK);
                    //将X的叔节点 U 设置为黑色
                    setColor(y, BLACK);
                    //将X的父节点的父节点 G 设置红色
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                }
                //如果X的叔节点 U 为黑色；这里会存在 两种情况（情况四、情况五）
                else {
                    //如果X节点为其父节点 P 的右子树，则进行左旋转（情况四）
                    if (x == rightOf(parentOf(x))) {
                        //将X的父节点作为X
                        x = parentOf(x);
                        //有旋转
                        rotateLeft(x);
                    }
                    //情况五
                    //将X的父节点 P 设置为黑色
                    setColor(parentOf(x), BLACK);
                    //将X的父节点的父节点 G 设置为红色
                    setColor(parentOf(parentOf(x)), RED);
                    //以X的父节点的父节点 G 为中心右旋转
                    rotateRight(parentOf(parentOf(x)));
                }
            }
            //如果X的父节点 P 是其父节点的父节点 G 的右节点
            else {
                //获取X的叔节点 U
                Entry<K, V> y = leftOf(parentOf(parentOf(x)));
                //如果X的叔节点 U 为红色 （情况三）
                if (colorOf(y) == RED) {
                    //将X的父节点 P 设置为黑色
                    setColor(parentOf(x), BLACK);
                    //将X的叔节点 U 设置为黑色
                    setColor(y, BLACK);
                    //将X的父节点的父节点 G 设置红色
                    setColor(parentOf(parentOf(x)), RED);
                    x = parentOf(parentOf(x));
                }
                //如果X的叔节点 U 为黑色；这里会存在两种情况（情况四， 情况五）
                else {
                    //如果X节点为其父节点 P 的左子树，则进行右旋转
                    if (x == leftOf(parentOf(x))) {
                        //将X的父节点作为X
                        x = parnetOf(x);
                        //右旋转
                        rotateRight(x);
                    }
                    //情况五
                    //将X的父节点 P 设置为黑色
                    setColor(parentOf(x), BLACK);
                    //将X的父节点的父节点 G 设置红色
                    setColor(parentOf(parentOf(x)), RED);
                    //以X的父节点的父节点 G 为中心右旋转
                    rotateLeft(parentOf(parentOf(x)));
                }
            }
        }
        //将根节点G强制设置为黑色
        root.color = BLACK;
    }
}

