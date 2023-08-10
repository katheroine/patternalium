abstract class ConvertingStepColleague {
  private ConvertingMediator convertingMediator;

  public ConvertingStepColleague(ConvertingMediator convertingMediator) {
    this.convertingMediator = convertingMediator;
  }

  public void processed() {
    convertingMediator.stepColleagueFinished(this);
  }
}
