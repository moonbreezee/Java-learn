package test.caipiao;

import java.util.Random;

class ProbabilitySimulationCalculation1 {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      buyBuyBuy(100000, 1000, 10);
    }
  }

  public static void buyBuyBuy(int myMoney, int buyPeriod, int periodCount) {

    System.out.println("买彩票前，我有" + myMoney + "元，购买" + buyPeriod + "次");
    Random random = new Random();
    int buyNumber;
    int winningNumber;
    StringBuilder winningMessage = new StringBuilder();
    for (int i = 0; i < buyPeriod; i++) {
      winningNumber = random.nextInt(1000);
      // System.out.println("本期中奖号码是" + winningNumber + " ");
      // System.out.print("我买的号码是");
      // 一天买10张彩票，每张2元
      for (int j = 0; j < periodCount; j++) {
        myMoney -= 2;
        buyNumber = random.nextInt(1000);
        // System.out.print(" " + buyNumber);
        if (buyNumber == winningNumber) {
          winningMessage.append("第").append(i).append("期我中奖了!中奖号码是").append(buyNumber).append("\n");
          myMoney += 1000;
        }
      }
      // System.out.println();
    }
    System.out.println("买彩票后，我有" + myMoney + "元");
    System.out.println(winningMessage.toString());
  }
}

class ProbabilitySimulationCalculation2 {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      buyBuyBuy(1000000, 1000, 500);
    }
  }

  public static void buyBuyBuy(int myMoney, int buyPeriod, int periodCount) {

    System.out.println("买彩票前，我有" + myMoney + "元");
    Random random = new Random();
    int buyNumber;
    int winningNumber;
    for (int i = 0; i < buyPeriod; i++) {
      winningNumber = random.nextInt(10000000);
      // 一天买10张彩票，每张2元
      for (int j = 0; j < periodCount; j++) {
        myMoney -= 2;
        buyNumber = random.nextInt(10000000);
        if (buyNumber == winningNumber) {
          myMoney += 5000000;
        }
      }
    }
    System.out.println("买彩票后，我有" + myMoney + "元");
  }
}