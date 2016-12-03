package petri;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import ru.bmstu.rk9.rao.lib.dpt.Activity;
import ru.bmstu.rk9.rao.lib.dpt.Logic;
import ru.bmstu.rk9.rao.lib.event.Event;
import ru.bmstu.rk9.rao.lib.pattern.Operation;
import ru.bmstu.rk9.rao.lib.resource.ComparableResource;
import ru.bmstu.rk9.rao.lib.runtime.RaoCollectionExtensions;
import ru.bmstu.rk9.rao.lib.runtime.RaoRuntime;
import ru.bmstu.rk9.rao.lib.sequence.Exponential;

@SuppressWarnings("all")
public class petri {
  public static class Позиция extends ComparableResource<petri.Позиция> {
    private Позиция(final int количество_маркеров) {
      this._количество_маркеров = количество_маркеров;
    }
    
    private Позиция() {
    }
    
    public static petri.Позиция create(final int количество_маркеров) {
      Позиция resource = new Позиция(количество_маркеров
      );
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().addResource(resource);
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getDatabase().memorizeResourceEntry(resource,
      		ru.bmstu.rk9.rao.lib.database.Database.ResourceEntryType.CREATED);
      return resource;
    }
    
    @Override
    public final void erase() {
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().eraseResource(this);
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getDatabase().memorizeResourceEntry(this,
      		ru.bmstu.rk9.rao.lib.database.Database.ResourceEntryType.ERASED);
    }
    
    private int _количество_маркеров;
    
    public int getКоличество_маркеров() {
      return _количество_маркеров;
    }
    
    public void setКоличество_маркеров(final int количество_маркеров) {
      Позиция actual = this;
      
      if (isShallowCopy)
      	actual = ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().copyOnWrite(this);
      
      actual._количество_маркеров = количество_маркеров;
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getDatabase().memorizeResourceEntry(actual,
      		ru.bmstu.rk9.rao.lib.database.Database.ResourceEntryType.ALTERED);
    }
    
    @Override
    public boolean checkEqual(final petri.Позиция other) {
      return this._количество_маркеров == other._количество_маркеров
      ;
    }
    
    @Override
    public petri.Позиция deepCopy() {
      Позиция copy = new Позиция();
      copy.setNumber(this.number);
      copy.setName(this.name);
      copy._количество_маркеров = this._количество_маркеров;
      
      return copy;
    }
    
    @Override
    public final String getTypeName() {
      return "petri.petri.Позиция";
    }
    
    @Override
    public final ByteBuffer serialize() {
      int _totalSize = 4;
      java.util.List<Integer> _positions = new java.util.ArrayList<>();
      
      int _currentPosition = 4;
      
      ByteBuffer buffer = ByteBuffer.allocate(_totalSize);
      
      buffer.putInt(_количество_маркеров);
      
      java.util.Iterator<Integer> _it = _positions.iterator();
      
      
      return buffer;
    }
    
    public static final petri.Позиция getAny() {
      return ru.bmstu.rk9.rao.lib.runtime.RaoCollectionExtensions.any(getAll());
    }
    
    public static final Collection<petri.Позиция> getAll() {
      return ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getAll(Позиция.class);
    }
    
    public static final Collection<petri.Позиция> getAccessible() {
      return ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getAccessible(Позиция.class);
    }
  }
  
  public static class Переход extends ComparableResource<petri.Переход> {
    private Переход(final petri.Позиция[] входы, final petri.Позиция[] выходы, final int время_перехода) {
      this._входы = входы;
      this._выходы = выходы;
      this._время_перехода = время_перехода;
    }
    
    private Переход() {
    }
    
    public static petri.Переход create(final petri.Позиция[] входы, final petri.Позиция[] выходы, final int время_перехода) {
      Переход resource = new Переход(входы, выходы, время_перехода
      );
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().addResource(resource);
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getDatabase().memorizeResourceEntry(resource,
      		ru.bmstu.rk9.rao.lib.database.Database.ResourceEntryType.CREATED);
      return resource;
    }
    
    @Override
    public final void erase() {
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().eraseResource(this);
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getDatabase().memorizeResourceEntry(this,
      		ru.bmstu.rk9.rao.lib.database.Database.ResourceEntryType.ERASED);
    }
    
    private petri.Позиция[] _входы;
    
    public petri.Позиция[] getВходы() {
      return _входы;
    }
    
    public void setВходы(final petri.Позиция[] входы) {
      Переход actual = this;
      
      if (isShallowCopy)
      	actual = ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().copyOnWrite(this);
      
      actual._входы = входы;
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getDatabase().memorizeResourceEntry(actual,
      		ru.bmstu.rk9.rao.lib.database.Database.ResourceEntryType.ALTERED);
    }
    
    private petri.Позиция[] _выходы;
    
    public petri.Позиция[] getВыходы() {
      return _выходы;
    }
    
    public void setВыходы(final petri.Позиция[] выходы) {
      Переход actual = this;
      
      if (isShallowCopy)
      	actual = ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().copyOnWrite(this);
      
      actual._выходы = выходы;
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getDatabase().memorizeResourceEntry(actual,
      		ru.bmstu.rk9.rao.lib.database.Database.ResourceEntryType.ALTERED);
    }
    
    private int _время_перехода;
    
    public int getВремя_перехода() {
      return _время_перехода;
    }
    
    public void setВремя_перехода(final int время_перехода) {
      Переход actual = this;
      
      if (isShallowCopy)
      	actual = ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().copyOnWrite(this);
      
      actual._время_перехода = время_перехода;
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getDatabase().memorizeResourceEntry(actual,
      		ru.bmstu.rk9.rao.lib.database.Database.ResourceEntryType.ALTERED);
    }
    
    @Override
    public boolean checkEqual(final petri.Переход other) {
      return this._входы.equals(other._входы)
       && this._выходы.equals(other._выходы)
       && this._время_перехода == other._время_перехода
      ;
    }
    
    @Override
    public petri.Переход deepCopy() {
      Переход copy = new Переход();
      copy.setNumber(this.number);
      copy.setName(this.name);
      copy._входы = this._входы;
      copy._выходы = this._выходы;
      copy._время_перехода = this._время_перехода;
      
      return copy;
    }
    
    @Override
    public final String getTypeName() {
      return "petri.petri.Переход";
    }
    
    @Override
    public final ByteBuffer serialize() {
      int _totalSize = 4;
      java.util.List<Integer> _positions = new java.util.ArrayList<>();
      
      int _currentPosition = 12;
      _positions.add(_currentPosition);
      String _входыValue = String.valueOf(_входы);
      byte[] _входыBytes = _входыValue.getBytes(java.nio.charset.StandardCharsets.UTF_8);
      int _входыLength = _входыBytes.length;
      _currentPosition += _входыLength + 4;
      _totalSize += _входыLength + 8;
      _positions.add(_currentPosition);
      String _выходыValue = String.valueOf(_выходы);
      byte[] _выходыBytes = _выходыValue.getBytes(java.nio.charset.StandardCharsets.UTF_8);
      int _выходыLength = _выходыBytes.length;
      _currentPosition += _выходыLength + 4;
      _totalSize += _выходыLength + 8;
      
      ByteBuffer buffer = ByteBuffer.allocate(_totalSize);
      
      buffer.putInt(_время_перехода);
      
      java.util.Iterator<Integer> _it = _positions.iterator();
      buffer.putInt(_it.next());
      buffer.putInt(_it.next());
      
      buffer.putInt(_входыLength);
      buffer.put(_входыBytes);
      buffer.putInt(_выходыLength);
      buffer.put(_выходыBytes);
      
      return buffer;
    }
    
    public static final petri.Переход getAny() {
      return ru.bmstu.rk9.rao.lib.runtime.RaoCollectionExtensions.any(getAll());
    }
    
    public static final Collection<petri.Переход> getAll() {
      return ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getAll(Переход.class);
    }
    
    public static final Collection<petri.Переход> getAccessible() {
      return ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getAccessible(Переход.class);
    }
  }
  
  public static final petri.Позиция getРобот_свободен() {
    if (!__initialized)
    	return __робот_свободенInitialValue;
    else
    	return (Позиция) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Позиция.class,
    			"petri.petri.робот_свободен");
  }
  
  private final static petri.Позиция __робот_свободенInitialValue = petri.Позиция.create(1);
  
  public static final petri.Позиция getНаличие_заготовки_в_накопителе() {
    if (!__initialized)
    	return __наличие_заготовки_в_накопителеInitialValue;
    else
    	return (Позиция) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Позиция.class,
    			"petri.petri.наличие_заготовки_в_накопителе");
  }
  
  private final static petri.Позиция __наличие_заготовки_в_накопителеInitialValue = petri.Позиция.create(0);
  
  public static final petri.Позиция getЗаготовка_установлена_на_первом_станке() {
    if (!__initialized)
    	return __заготовка_установлена_на_первом_станкеInitialValue;
    else
    	return (Позиция) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Позиция.class,
    			"petri.petri.заготовка_установлена_на_первом_станке");
  }
  
  private final static petri.Позиция __заготовка_установлена_на_первом_станкеInitialValue = petri.Позиция.create(0);
  
  public static final petri.Позиция getЗаготовка_обработана_на_первом_станке() {
    if (!__initialized)
    	return __заготовка_обработана_на_первом_станкеInitialValue;
    else
    	return (Позиция) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Позиция.class,
    			"petri.petri.заготовка_обработана_на_первом_станке");
  }
  
  private final static petri.Позиция __заготовка_обработана_на_первом_станкеInitialValue = petri.Позиция.create(0);
  
  public static final petri.Позиция getПервый_станок_свободен() {
    if (!__initialized)
    	return __первый_станок_свободенInitialValue;
    else
    	return (Позиция) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Позиция.class,
    			"petri.petri.первый_станок_свободен");
  }
  
  private final static petri.Позиция __первый_станок_свободенInitialValue = petri.Позиция.create(1);
  
  public static final petri.Позиция getЗаготовка_установлена_на_втором_станке() {
    if (!__initialized)
    	return __заготовка_установлена_на_втором_станкеInitialValue;
    else
    	return (Позиция) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Позиция.class,
    			"petri.petri.заготовка_установлена_на_втором_станке");
  }
  
  private final static petri.Позиция __заготовка_установлена_на_втором_станкеInitialValue = petri.Позиция.create(0);
  
  public static final petri.Позиция getЗаготовка_обработана_на_втором_станке() {
    if (!__initialized)
    	return __заготовка_обработана_на_втором_станкеInitialValue;
    else
    	return (Позиция) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Позиция.class,
    			"petri.petri.заготовка_обработана_на_втором_станке");
  }
  
  private final static petri.Позиция __заготовка_обработана_на_втором_станкеInitialValue = petri.Позиция.create(0);
  
  public static final petri.Позиция getВторой_станок_свободен() {
    if (!__initialized)
    	return __второй_станок_свободенInitialValue;
    else
    	return (Позиция) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Позиция.class,
    			"petri.petri.второй_станок_свободен");
  }
  
  private final static petri.Позиция __второй_станок_свободенInitialValue = petri.Позиция.create(1);
  
  public static final petri.Позиция getНаличие_обработанной_заготовки_в_накопителе() {
    if (!__initialized)
    	return __наличие_обработанной_заготовки_в_накопителеInitialValue;
    else
    	return (Позиция) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Позиция.class,
    			"petri.petri.наличие_обработанной_заготовки_в_накопителе");
  }
  
  private final static petri.Позиция __наличие_обработанной_заготовки_в_накопителеInitialValue = petri.Позиция.create(0);
  
  public static final petri.Переход getЗагрузка_первого_станка() {
    if (!__initialized)
    	return __загрузка_первого_станкаInitialValue;
    else
    	return (Переход) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Переход.class,
    			"petri.petri.загрузка_первого_станка");
  }
  
  private final static petri.Переход __загрузка_первого_станкаInitialValue = petri.Переход.create(((petri.Позиция[])Conversions.unwrapArray(Arrays.<petri.Позиция>asList(petri.getРобот_свободен(), petri.getПервый_станок_свободен(), petri.getНаличие_заготовки_в_накопителе()), petri.Позиция.class)), 
    ((petri.Позиция[])Conversions.unwrapArray(Arrays.<petri.Позиция>asList(petri.getРобот_свободен(), petri.getЗаготовка_установлена_на_первом_станке()), petri.Позиция.class)), 5);
  
  public static final petri.Переход getОбработка_на_первом_станке() {
    if (!__initialized)
    	return __обработка_на_первом_станкеInitialValue;
    else
    	return (Переход) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Переход.class,
    			"petri.petri.обработка_на_первом_станке");
  }
  
  private final static petri.Переход __обработка_на_первом_станкеInitialValue = petri.Переход.create(((petri.Позиция[])Conversions.unwrapArray(Arrays.<petri.Позиция>asList(petri.getЗаготовка_установлена_на_первом_станке()), petri.Позиция.class)), 
    ((petri.Позиция[])Conversions.unwrapArray(Arrays.<petri.Позиция>asList(petri.getЗаготовка_обработана_на_первом_станке()), petri.Позиция.class)), 10);
  
  public static final petri.Переход getПереустановка() {
    if (!__initialized)
    	return __переустановкаInitialValue;
    else
    	return (Переход) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Переход.class,
    			"petri.petri.переустановка");
  }
  
  private final static petri.Переход __переустановкаInitialValue = petri.Переход.create(((petri.Позиция[])Conversions.unwrapArray(Arrays.<petri.Позиция>asList(petri.getРобот_свободен(), petri.getЗаготовка_обработана_на_первом_станке(), petri.getВторой_станок_свободен()), petri.Позиция.class)), 
    ((petri.Позиция[])Conversions.unwrapArray(Arrays.<petri.Позиция>asList(petri.getРобот_свободен(), petri.getЗаготовка_установлена_на_втором_станке(), petri.getПервый_станок_свободен()), petri.Позиция.class)), 3);
  
  public static final petri.Переход getОбработка_на_втором_станке() {
    if (!__initialized)
    	return __обработка_на_втором_станкеInitialValue;
    else
    	return (Переход) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Переход.class,
    			"petri.petri.обработка_на_втором_станке");
  }
  
  private final static petri.Переход __обработка_на_втором_станкеInitialValue = petri.Переход.create(((petri.Позиция[])Conversions.unwrapArray(Arrays.<petri.Позиция>asList(petri.getЗаготовка_установлена_на_втором_станке()), petri.Позиция.class)), 
    ((petri.Позиция[])Conversions.unwrapArray(Arrays.<petri.Позиция>asList(petri.getЗаготовка_обработана_на_втором_станке()), petri.Позиция.class)), 15);
  
  public static final petri.Переход getРазгрузка_второго_станка() {
    if (!__initialized)
    	return __разгрузка_второго_станкаInitialValue;
    else
    	return (Переход) ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.getModelState().getResource(
    			Переход.class,
    			"petri.petri.разгрузка_второго_станка");
  }
  
  private final static petri.Переход __разгрузка_второго_станкаInitialValue = petri.Переход.create(((petri.Позиция[])Conversions.unwrapArray(Arrays.<petri.Позиция>asList(petri.getЗаготовка_обработана_на_втором_станке(), petri.getРобот_свободен()), petri.Позиция.class)), 
    ((petri.Позиция[])Conversions.unwrapArray(Arrays.<petri.Позиция>asList(petri.getРобот_свободен(), petri.getНаличие_обработанной_заготовки_в_накопителе(), petri.getВторой_станок_свободен()), petri.Позиция.class)), 4);
  
  public static final boolean проверка_массива(final petri.Позиция[] массив) {
    int j = 0;
    for (int i = 0; (i < массив.length); i++) {
      petri.Позиция _get = массив[i];
      int _количество_маркеров = _get.getКоличество_маркеров();
      boolean _greaterThan = (_количество_маркеров > 0);
      if (_greaterThan) {
        j = (j + 1);
      }
    }
    int _length = массив.length;
    boolean _equals = (j == _length);
    if (_equals) {
      return true;
    } else {
      return false;
    }
  }
  
  public static class Событие_прихода_заготовки extends Event {
    private Событие_прихода_заготовки(final double time) {
      this.time = time;
    }
    
    @Override
    public final String getName() {
      return "petri.petri.Событие_прихода_заготовки";
    }
    
    @Override
    protected final void execute() {
      double _currentTime = RaoRuntime.getCurrentTime();
      Double _next = petri.интервал_прихода.next();
      double _plus = (_currentTime + (_next).doubleValue());
      petri.Событие_прихода_заготовки.plan(_plus);
      petri.Позиция _наличие_заготовки_в_накопителе = petri.getНаличие_заготовки_в_накопителе();
      petri.Позиция _наличие_заготовки_в_накопителе_1 = petri.getНаличие_заготовки_в_накопителе();
      int _количество_маркеров = _наличие_заготовки_в_накопителе_1.getКоличество_маркеров();
      int _plus_1 = (_количество_маркеров + 1);
      _наличие_заготовки_в_накопителе.setКоличество_маркеров(_plus_1);
    }
    
    public static final void plan(final double time) {
      Событие_прихода_заготовки event = new Событие_прихода_заготовки(time
      );
      ru.bmstu.rk9.rao.lib.simulator.CurrentSimulator.pushEvent(event);
    }
  }
  
  public static class Работа_сети_Петри extends Operation {
    public static Supplier<petri.Работа_сети_Петри> create() {
      return () -> new Работа_сети_Петри();
    }
    
    private Работа_сети_Петри() {
      
    }
    
    private petri.Переход __resolve_переход() {
      Collection<petri.Переход> _accessible = petri.Переход.getAccessible();
      final Function1<petri.Переход, Boolean> _function = (petri.Переход it) -> {
        petri.Позиция[] _входы = it.getВходы();
        return Boolean.valueOf(petri.проверка_массива(_входы));
      };
      Iterable<petri.Переход> _filter = IterableExtensions.<petri.Переход>filter(_accessible, _function);
      petri.Переход _any = RaoCollectionExtensions.<petri.Переход>any(_filter);
      return _any;
    }
    
    private petri.Переход _переход;
    
    @Override
    public final void begin() {
      for (int i = 0; (i < this._переход.getВходы().length); i++) {
        petri.Позиция[] _входы = this._переход.getВходы();
        petri.Позиция _get = _входы[i];
        petri.Позиция[] _входы_1 = this._переход.getВходы();
        petri.Позиция _get_1 = _входы_1[i];
        int _количество_маркеров = _get_1.getКоличество_маркеров();
        int _minus = (_количество_маркеров - 1);
        _get.setКоличество_маркеров(_minus);
      }
    }
    
    @Override
    public final double duration() {
      return this._переход.getВремя_перехода();
    }
    
    @Override
    public final void end() {
      for (int i = 0; (i < this._переход.getВыходы().length); i++) {
        petri.Позиция[] _выходы = this._переход.getВыходы();
        petri.Позиция _get = _выходы[i];
        petri.Позиция[] _выходы_1 = this._переход.getВыходы();
        petri.Позиция _get_1 = _выходы_1[i];
        int _количество_маркеров = _get_1.getКоличество_маркеров();
        int _plus = (_количество_маркеров + 1);
        _get.setКоличество_маркеров(_plus);
      }
    }
    
    @Override
    public final boolean selectRelevantResources() {
      this._переход = __resolve_переход();
      if (this._переход == null) {
      	finish();
      	return false;
      }
      this._переход.take();
      this.relevantResourcesNumbers.add(this._переход.getNumber());
      return true;
    }
    
    @Override
    public final void finish() {
      if (this._переход != null)
      	this._переход.put();
    }
    
    @Override
    public final String getTypeName() {
      return "petri.petri.Работа_сети_Петри";
    }
  }
  
  public final static Exponential интервал_прихода = new Exponential(123456789, (1 / 30.0));
  
  public static class Модель extends Logic {
    private Activity сеть_Петри;
    
    private final Activity initializeСеть_Петри() {
      Supplier<petri.Работа_сети_Петри> _create = petri.Работа_сети_Петри.create();
      Activity _activity = new Activity(_create);
      return _activity;
    }
    
    @Override
    protected final void initializeActivities() {
      this.сеть_Петри = initializeСеть_Петри();
      this.сеть_Петри.setName("сеть_Петри");
      addActivity(this.сеть_Петри);
    }
    
    @Override
    public final String getTypeName() {
      return "petri.petri.Модель";
    }
  }
  
  protected static class init implements Runnable {
    @Override
    public final void run() {
      Double _next = petri.интервал_прихода.next();
      petri.Событие_прихода_заготовки.plan((_next).doubleValue());
    }
  }
  
  protected static class terminateCondition implements Supplier<Boolean> {
    @Override
    public final Boolean get() {
      petri.Позиция _наличие_обработанной_заготовки_в_накопителе = petri.getНаличие_обработанной_заготовки_в_накопителе();
      int _количество_маркеров = _наличие_обработанной_заготовки_в_накопителе.getКоличество_маркеров();
      return Boolean.valueOf((_количество_маркеров == 10));
    }
  }
  
  protected static class resourcesPreinitializer implements Runnable {
    @Override
    public final void run() {
      ru.bmstu.rk9.rao.lib.resource.Resource робот_свободен = __робот_свободенInitialValue;
      робот_свободен.setName("petri.petri.робот_свободен");
      ru.bmstu.rk9.rao.lib.resource.Resource наличие_заготовки_в_накопителе = __наличие_заготовки_в_накопителеInitialValue;
      наличие_заготовки_в_накопителе.setName("petri.petri.наличие_заготовки_в_накопителе");
      ru.bmstu.rk9.rao.lib.resource.Resource заготовка_установлена_на_первом_станке = __заготовка_установлена_на_первом_станкеInitialValue;
      заготовка_установлена_на_первом_станке.setName("petri.petri.заготовка_установлена_на_первом_станке");
      ru.bmstu.rk9.rao.lib.resource.Resource заготовка_обработана_на_первом_станке = __заготовка_обработана_на_первом_станкеInitialValue;
      заготовка_обработана_на_первом_станке.setName("petri.petri.заготовка_обработана_на_первом_станке");
      ru.bmstu.rk9.rao.lib.resource.Resource первый_станок_свободен = __первый_станок_свободенInitialValue;
      первый_станок_свободен.setName("petri.petri.первый_станок_свободен");
      ru.bmstu.rk9.rao.lib.resource.Resource заготовка_установлена_на_втором_станке = __заготовка_установлена_на_втором_станкеInitialValue;
      заготовка_установлена_на_втором_станке.setName("petri.petri.заготовка_установлена_на_втором_станке");
      ru.bmstu.rk9.rao.lib.resource.Resource заготовка_обработана_на_втором_станке = __заготовка_обработана_на_втором_станкеInitialValue;
      заготовка_обработана_на_втором_станке.setName("petri.petri.заготовка_обработана_на_втором_станке");
      ru.bmstu.rk9.rao.lib.resource.Resource второй_станок_свободен = __второй_станок_свободенInitialValue;
      второй_станок_свободен.setName("petri.petri.второй_станок_свободен");
      ru.bmstu.rk9.rao.lib.resource.Resource наличие_обработанной_заготовки_в_накопителе = __наличие_обработанной_заготовки_в_накопителеInitialValue;
      наличие_обработанной_заготовки_в_накопителе.setName("petri.petri.наличие_обработанной_заготовки_в_накопителе");
      ru.bmstu.rk9.rao.lib.resource.Resource загрузка_первого_станка = __загрузка_первого_станкаInitialValue;
      загрузка_первого_станка.setName("petri.petri.загрузка_первого_станка");
      ru.bmstu.rk9.rao.lib.resource.Resource обработка_на_первом_станке = __обработка_на_первом_станкеInitialValue;
      обработка_на_первом_станке.setName("petri.petri.обработка_на_первом_станке");
      ru.bmstu.rk9.rao.lib.resource.Resource переустановка = __переустановкаInitialValue;
      переустановка.setName("petri.petri.переустановка");
      ru.bmstu.rk9.rao.lib.resource.Resource обработка_на_втором_станке = __обработка_на_втором_станкеInitialValue;
      обработка_на_втором_станке.setName("petri.petri.обработка_на_втором_станке");
      ru.bmstu.rk9.rao.lib.resource.Resource разгрузка_второго_станка = __разгрузка_второго_станкаInitialValue;
      разгрузка_второго_станка.setName("petri.petri.разгрузка_второго_станка");
      
      __initialized = true;
    }
  }
  
  private static boolean __initialized = false;
}
