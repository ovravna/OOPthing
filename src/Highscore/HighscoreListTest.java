package Highscore;

import junit.framework.TestCase;
import no.hal.jex.jextest.extensions.JextestExtensions;
import no.hal.jex.runtime.JExercise;

@JExercise(description = "Tests patterns.observable.HighscoreList")
@SuppressWarnings("all")
public class HighscoreListTest extends TestCase {
  private HighscoreList highscoreList;

  private HighscoreList _init_highscoreList() {
    HighscoreList _highscoreList = new HighscoreList(3);
    return _highscoreList;
  }

  private int pos1;

  private int _init_pos1() {
    return (-1);
  }

  private int pos2;

  private int _init_pos2() {
    return (-1);
  }

  @Override
  protected void setUp() {
    highscoreList = _init_highscoreList();
    pos1 = _init_pos1();
    pos2 = _init_pos2();

  }

  private void addResult(final int pos, final int element) {
    this.pos1 = pos;
    this.highscoreList.addResult(Integer.valueOf(element));
    TestCase.assertEquals(this.pos1, this.pos2);
  }

  private void operator_assertEquals(final HighscoreList highscoreList, final int[] elements) {
    int _length = elements.length;
    int _size = highscoreList.size();
    JextestExtensions.operator_assertEquals(_length, _size);
    int i = 0;
    for (final int element : elements) {
      {
        int _element = highscoreList.getElement(i);
        JextestExtensions.operator_assertEquals(_element, element);
        i++;
      }
    }
  }

  @JExercise(tests = "HighscoreList(int)", description = "Tests \n\t\tinitialization\n")
  public void testConstructor() {
    _test__constructor_transitions0_effect_state();

  }

  @JExercise(tests = "HighscoreList(int);void addResult(Integer)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>highscoreList.addResult(5)</li>\n\t\t<li>highscoreList.addResult(6)</li>\n\t\t<li>highscoreList.addResult(2)</li>\n\t\t</ul>\n")
  public void testAddElementSimple() {
    _transition_exprAction__addElementSimple_transitions0_actions0();
    _test__addElementSimple_transitions0_effect_state();
    _transition_exprAction__addElementSimple_transitions1_actions0();
    _test__addElementSimple_transitions1_effect_state();
    _transition_exprAction__addElementSimple_transitions2_actions0();
    _test__addElementSimple_transitions2_effect_state();

  }

  @JExercise(tests = "HighscoreList(int);void addResult(Integer)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>highscoreList.addResult(5), highscoreList.addResult(6), highscoreList.addResult(2)</li>\n\t\t<li>highscoreList.addResult(3)</li>\n\t\t<li>highscoreList.addResult(7)</li>\n\t\t</ul>\n")
  public void testAddElementMoreThanMax() {
    _transition_exprAction__addElementMoreThanMax_transitions0_actions0();
    _transition_exprAction__addElementMoreThanMax_transitions0_actions1();
    _transition_exprAction__addElementMoreThanMax_transitions0_actions2();
    _test__addElementMoreThanMax_transitions0_effect_state();
    _transition_exprAction__addElementMoreThanMax_transitions1_actions0();
    _test__addElementMoreThanMax_transitions1_effect_state();
    _transition_exprAction__addElementMoreThanMax_transitions2_actions0();
    _test__addElementMoreThanMax_transitions2_effect_state();

  }

  @JExercise(tests = "HighscoreList(int);void addResult(Integer)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>highscoreList.addResult(5), highscoreList.addResult(6), highscoreList.addResult(2)</li>\n\t\t<li>highscoreList.addResult(2)</li>\n\t\t</ul>\n")
  public void testAddElementDuplicate() {
    _transition_exprAction__addElementDuplicate_transitions0_actions0();
    _transition_exprAction__addElementDuplicate_transitions0_actions1();
    _transition_exprAction__addElementDuplicate_transitions0_actions2();
    _test__addElementDuplicate_transitions0_effect_state();
    _transition_exprAction__addElementDuplicate_transitions1_actions0();
    _test__addElementDuplicate_transitions1_effect_state();

  }

  @JExercise(tests = "HighscoreList(int);void addHighscoreListListener(patterns.observable.HighscoreListListener)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>highscoreList.addHighscoreListListener([list, pos | pos2 = pos]), addResult(0, 5)</li>\n\t\t<li>addResult(1, 6)</li>\n\t\t<li>addResult(0, 2)</li>\n\t\t</ul>\n")
  public void testListListenerSimple() {
    _transition_exprAction__listListenerSimple_transitions0_actions0();
    _transition_exprAction__listListenerSimple_transitions0_actions1();
    _test__listListenerSimple_transitions0_effect_state();
    _transition_exprAction__listListenerSimple_transitions1_actions0();
    _test__listListenerSimple_transitions1_effect_state();
    _transition_exprAction__listListenerSimple_transitions2_actions0();
    _test__listListenerSimple_transitions2_effect_state();

  }

  @JExercise(tests = "HighscoreList(int);void addHighscoreListListener(patterns.observable.HighscoreListListener);void addResult(Integer)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>highscoreList.addHighscoreListListener([list, pos | pos2 = pos]), highscoreList.addResult(5), highscoreList.addResult(6), highscoreList.addResult(2)</li>\n\t\t<li>addResult(1, 3)</li>\n\t\t<li>pos2 = -1, addResult(-1, 7)</li>\n\t\t</ul>\n")
  public void testListListenerMoreThanMax() {
    _transition_exprAction__listListenerMoreThanMax_transitions0_actions0();
    _transition_exprAction__listListenerMoreThanMax_transitions0_actions1();
    _transition_exprAction__listListenerMoreThanMax_transitions0_actions2();
    _transition_exprAction__listListenerMoreThanMax_transitions0_actions3();
    _test__listListenerMoreThanMax_transitions0_effect_state();
    _transition_exprAction__listListenerMoreThanMax_transitions1_actions0();
    _test__listListenerMoreThanMax_transitions1_effect_state();
    _transition_exprAction__listListenerMoreThanMax_transitions2_actions0();
    _transition_exprAction__listListenerMoreThanMax_transitions2_actions1();
    _test__listListenerMoreThanMax_transitions2_effect_state();

  }

  @JExercise(tests = "HighscoreList(int);void addHighscoreListListener(patterns.observable.HighscoreListListener);void addResult(Integer)", description = "Tests \n\t\tthe following sequence:\n\t\t<ul>\n\t\t<li>highscoreList.addHighscoreListListener([list, pos | pos2 = pos]), highscoreList.addResult(5), highscoreList.addResult(6), highscoreList.addResult(2)</li>\n\t\t<li>addResult(1, 2)</li>\n\t\t</ul>\n")
  public void testListListenerDuplicate() {
    _transition_exprAction__listListenerDuplicate_transitions0_actions0();
    _transition_exprAction__listListenerDuplicate_transitions0_actions1();
    _transition_exprAction__listListenerDuplicate_transitions0_actions2();
    _transition_exprAction__listListenerDuplicate_transitions0_actions3();
    _test__listListenerDuplicate_transitions0_effect_state();
    _transition_exprAction__listListenerDuplicate_transitions1_actions0();
    _test__listListenerDuplicate_transitions1_effect_state();

  }

  private void _test__constructor_transitions0_effect_state() {
    _test__constructor_transitions0_effect_state_objectTests0_test(highscoreList);

  }

  private void _test__constructor_transitions0_effect_state_objectTests0_test(final HighscoreList it) {

    int _size = it.size();
    assertEquals("size() == 0 failed", 0, _size);

  }

  private void _transition_exprAction__addElementSimple_transitions0_actions0() {
    try {

      this.highscoreList.addResult(Integer.valueOf(5));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(5) failed: " + error.getMessage());
    }

  }

  private void _test__addElementSimple_transitions0_effect_state() {
    _test__addElementSimple_transitions0_effect_state_objectTests0_test();

  }

  private void _test__addElementSimple_transitions0_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 5 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[5] failed after highscoreList.addResult(5): " + error.getMessage());
    }

  }

  private void _transition_exprAction__addElementSimple_transitions1_actions0() {
    try {

      this.highscoreList.addResult(Integer.valueOf(6));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(6) failed: " + error.getMessage());
    }

  }

  private void _test__addElementSimple_transitions1_effect_state() {
    _test__addElementSimple_transitions1_effect_state_objectTests0_test();

  }

  private void _test__addElementSimple_transitions1_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 5, 6 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[5, 6] failed after highscoreList.addResult(6): " + error.getMessage());
    }

  }

  private void _transition_exprAction__addElementSimple_transitions2_actions0() {
    try {

      this.highscoreList.addResult(Integer.valueOf(2));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(2) failed: " + error.getMessage());
    }

  }

  private void _test__addElementSimple_transitions2_effect_state() {
    _test__addElementSimple_transitions2_effect_state_objectTests0_test();

  }

  private void _test__addElementSimple_transitions2_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 5, 6 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 5, 6] failed after highscoreList.addResult(2): " + error.getMessage());
    }

  }

  private void _transition_exprAction__addElementMoreThanMax_transitions0_actions0() {
    try {

      this.highscoreList.addResult(Integer.valueOf(5));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(5) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__addElementMoreThanMax_transitions0_actions1() {
    try {

      this.highscoreList.addResult(Integer.valueOf(6));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(6) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__addElementMoreThanMax_transitions0_actions2() {
    try {

      this.highscoreList.addResult(Integer.valueOf(2));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(2) failed: " + error.getMessage());
    }

  }

  private void _test__addElementMoreThanMax_transitions0_effect_state() {
    _test__addElementMoreThanMax_transitions0_effect_state_objectTests0_test();

  }

  private void _test__addElementMoreThanMax_transitions0_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 5, 6 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 5, 6] failed after highscoreList.addResult(5) ,highscoreList.addResult(6) ,highscoreList.addResult(2): " + error.getMessage());
    }

  }

  private void _transition_exprAction__addElementMoreThanMax_transitions1_actions0() {
    try {

      this.highscoreList.addResult(Integer.valueOf(3));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(3) failed: " + error.getMessage());
    }

  }

  private void _test__addElementMoreThanMax_transitions1_effect_state() {
    _test__addElementMoreThanMax_transitions1_effect_state_objectTests0_test();

  }

  private void _test__addElementMoreThanMax_transitions1_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 3, 5 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 3, 5] failed after highscoreList.addResult(3): " + error.getMessage());
    }

  }

  private void _transition_exprAction__addElementMoreThanMax_transitions2_actions0() {
    try {

      this.highscoreList.addResult(Integer.valueOf(7));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(7) failed: " + error.getMessage());
    }

  }

  private void _test__addElementMoreThanMax_transitions2_effect_state() {
    _test__addElementMoreThanMax_transitions2_effect_state_objectTests0_test();

  }

  private void _test__addElementMoreThanMax_transitions2_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 3, 5 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 3, 5] failed after highscoreList.addResult(7): " + error.getMessage());
    }

  }

  private void _transition_exprAction__addElementDuplicate_transitions0_actions0() {
    try {

      this.highscoreList.addResult(Integer.valueOf(5));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(5) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__addElementDuplicate_transitions0_actions1() {
    try {

      this.highscoreList.addResult(Integer.valueOf(6));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(6) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__addElementDuplicate_transitions0_actions2() {
    try {

      this.highscoreList.addResult(Integer.valueOf(2));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(2) failed: " + error.getMessage());
    }

  }

  private void _test__addElementDuplicate_transitions0_effect_state() {
    _test__addElementDuplicate_transitions0_effect_state_objectTests0_test();

  }

  private void _test__addElementDuplicate_transitions0_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 5, 6 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 5, 6] failed after highscoreList.addResult(5) ,highscoreList.addResult(6) ,highscoreList.addResult(2): " + error.getMessage());
    }

  }

  private void _transition_exprAction__addElementDuplicate_transitions1_actions0() {
    try {

      this.highscoreList.addResult(Integer.valueOf(2));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(2) failed: " + error.getMessage());
    }

  }

  private void _test__addElementDuplicate_transitions1_effect_state() {
    _test__addElementDuplicate_transitions1_effect_state_objectTests0_test();

  }

  private void _test__addElementDuplicate_transitions1_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 2, 5 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 2, 5] failed after highscoreList.addResult(2): " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerSimple_transitions0_actions0() {
    try {

      final HighscoreListListener _function = new HighscoreListListener() {
        public void listChanged(final HighscoreList list, final int pos) {
          HighscoreListTest.this.pos2 = pos;
        }
      };
      this.highscoreList.addHighscoreListListener(_function);
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addHighscoreListListener([list, pos | pos2 = pos]) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerSimple_transitions0_actions1() {
    try {

      this.addResult(0, 5);
      } catch (junit.framework.AssertionFailedError error) {
      fail("addResult(0, 5) failed: " + error.getMessage());
    }

  }

  private void _test__listListenerSimple_transitions0_effect_state() {
    _test__listListenerSimple_transitions0_effect_state_objectTests0_test();

  }

  private void _test__listListenerSimple_transitions0_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 5 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[5] failed after highscoreList.addHighscoreListListener([list, pos | pos2 = pos]) ,addResult(0, 5): " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerSimple_transitions1_actions0() {
    try {

      this.addResult(1, 6);
      } catch (junit.framework.AssertionFailedError error) {
      fail("addResult(1, 6) failed: " + error.getMessage());
    }

  }

  private void _test__listListenerSimple_transitions1_effect_state() {
    _test__listListenerSimple_transitions1_effect_state_objectTests0_test();

  }

  private void _test__listListenerSimple_transitions1_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 5, 6 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[5, 6] failed after addResult(1, 6): " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerSimple_transitions2_actions0() {
    try {

      this.addResult(0, 2);
      } catch (junit.framework.AssertionFailedError error) {
      fail("addResult(0, 2) failed: " + error.getMessage());
    }

  }

  private void _test__listListenerSimple_transitions2_effect_state() {
    _test__listListenerSimple_transitions2_effect_state_objectTests0_test();

  }

  private void _test__listListenerSimple_transitions2_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 5, 6 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 5, 6] failed after addResult(0, 2): " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerMoreThanMax_transitions0_actions0() {
    try {

      final HighscoreListListener _function = new HighscoreListListener() {
        public void listChanged(final HighscoreList list, final int pos) {
          HighscoreListTest.this.pos2 = pos;
        }
      };
      this.highscoreList.addHighscoreListListener(_function);
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addHighscoreListListener([list, pos | pos2 = pos]) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerMoreThanMax_transitions0_actions1() {
    try {

      this.highscoreList.addResult(Integer.valueOf(5));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(5) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerMoreThanMax_transitions0_actions2() {
    try {

      this.highscoreList.addResult(Integer.valueOf(6));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(6) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerMoreThanMax_transitions0_actions3() {
    try {

      this.highscoreList.addResult(Integer.valueOf(2));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(2) failed: " + error.getMessage());
    }

  }

  private void _test__listListenerMoreThanMax_transitions0_effect_state() {
    _test__listListenerMoreThanMax_transitions0_effect_state_objectTests0_test();

  }

  private void _test__listListenerMoreThanMax_transitions0_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 5, 6 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 5, 6] failed after highscoreList.addHighscoreListListener([list, pos | pos2 = pos]) ,highscoreList.addResult(5) ,highscoreList.addResult(6) ,highscoreList.addResult(2): " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerMoreThanMax_transitions1_actions0() {
    try {

      this.addResult(1, 3);
      } catch (junit.framework.AssertionFailedError error) {
      fail("addResult(1, 3) failed: " + error.getMessage());
    }

  }

  private void _test__listListenerMoreThanMax_transitions1_effect_state() {
    _test__listListenerMoreThanMax_transitions1_effect_state_objectTests0_test();

  }

  private void _test__listListenerMoreThanMax_transitions1_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 3, 5 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 3, 5] failed after addResult(1, 3): " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerMoreThanMax_transitions2_actions0() {
    try {

      this.pos2 = (-1);
      } catch (junit.framework.AssertionFailedError error) {
      fail("pos2 = -1 failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerMoreThanMax_transitions2_actions1() {
    try {

      this.addResult((-1), 7);
      } catch (junit.framework.AssertionFailedError error) {
      fail("addResult(-1, 7) failed: " + error.getMessage());
    }

  }

  private void _test__listListenerMoreThanMax_transitions2_effect_state() {
    _test__listListenerMoreThanMax_transitions2_effect_state_objectTests0_test();

  }

  private void _test__listListenerMoreThanMax_transitions2_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 3, 5 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 3, 5] failed after pos2 = -1 ,addResult(-1, 7): " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerDuplicate_transitions0_actions0() {
    try {

      final HighscoreListListener _function = new HighscoreListListener() {
        public void listChanged(final HighscoreList list, final int pos) {
          HighscoreListTest.this.pos2 = pos;
        }
      };
      this.highscoreList.addHighscoreListListener(_function);
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addHighscoreListListener([list, pos | pos2 = pos]) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerDuplicate_transitions0_actions1() {
    try {

      this.highscoreList.addResult(Integer.valueOf(5));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(5) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerDuplicate_transitions0_actions2() {
    try {

      this.highscoreList.addResult(Integer.valueOf(6));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(6) failed: " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerDuplicate_transitions0_actions3() {
    try {

      this.highscoreList.addResult(Integer.valueOf(2));
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList.addResult(2) failed: " + error.getMessage());
    }

  }

  private void _test__listListenerDuplicate_transitions0_effect_state() {
    _test__listListenerDuplicate_transitions0_effect_state_objectTests0_test();

  }

  private void _test__listListenerDuplicate_transitions0_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 5, 6 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 5, 6] failed after highscoreList.addHighscoreListListener([list, pos | pos2 = pos]) ,highscoreList.addResult(5) ,highscoreList.addResult(6) ,highscoreList.addResult(2): " + error.getMessage());
    }

  }

  private void _transition_exprAction__listListenerDuplicate_transitions1_actions0() {
    try {

      this.addResult(1, 2);
      } catch (junit.framework.AssertionFailedError error) {
      fail("addResult(1, 2) failed: " + error.getMessage());
    }

  }

  private void _test__listListenerDuplicate_transitions1_effect_state() {
    _test__listListenerDuplicate_transitions1_effect_state_objectTests0_test();

  }

  private void _test__listListenerDuplicate_transitions1_effect_state_objectTests0_test() {
    try {

      this.operator_assertEquals(
        this.highscoreList, new int[] { 2, 2, 5 });
      } catch (junit.framework.AssertionFailedError error) {
      fail("highscoreList ?= #[2, 2, 5] failed after addResult(1, 2): " + error.getMessage());
    }

  }

  public static void main(final String[] args) {
    no.hal.jex.standalone.JexStandalone.main(HighscoreListTest.class);
  }
}