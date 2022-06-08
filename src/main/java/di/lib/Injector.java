package di.lib;

import di.service.AccountService;
import di.service.AuthenticationManager;
import di.service.BankService;
import di.service.LogService;
import di.service.impl.AccountServiceImpl;
import di.service.impl.AuthenticationManagerImpl;
import di.service.impl.BankServiceImpl;
import di.service.impl.LogServiceImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Injector {
  private static final Injector injector = new Injector();
  private final Map<Class<?>, Object> instances = new HashMap<>();

  public static Injector getInjector() {
    return injector;
  }

  public Object getInstance(Class<?> interfaceClazz) {
    Object clazzImplementationInstance = null;
    Class<?> clazz = findImplementation(interfaceClazz);
    Field[] declaredFields = clazz.getDeclaredFields();
    for (Field field : declaredFields) {
      if (field.isAnnotationPresent(Inject.class)) {
        // create a new object of field type
        Object fieldInstance = getInstance(field.getType());

        // create an object of interface class (or implementation class)
        clazzImplementationInstance = createNewInstance(clazz);

        // set 'field type object' to 'interfaceClazz object'
        try {
          field.setAccessible(true);
          field.set(clazzImplementationInstance, fieldInstance);
        } catch (IllegalAccessException e) {
          throw new RuntimeException(
              "Can't initialise field value. Class "
                  + clazz.getName()
                  + ". Field: "
                  + field.getName());
        }
      }
    }
    if (clazzImplementationInstance == null) {
      clazzImplementationInstance = createNewInstance(clazz);
    }
    return clazzImplementationInstance;
  }

  private Object createNewInstance(Class<?> clazz) {
    // if we created the object - let's use it
    if (instances.containsKey(clazz)) {
      return instances.get(clazz);
    }
    // create new object
    try {
      Constructor<?> constructor = clazz.getConstructor();
      Object instance = constructor.newInstance();
      instances.put(clazz, instance);
      return instance;
    } catch (NoSuchMethodException
        | InvocationTargetException
        | InstantiationException
        | IllegalAccessException e) {
      throw new RuntimeException("Can't create a new instance of " + clazz.getName());
    }
  }

  private Class<?> findImplementation(Class<?> interfaceClazz) {
    Map<Class<?>, Class<?>> interfaceImplementations = new HashMap<>();
    interfaceImplementations.put(BankService.class, BankServiceImpl.class);
    interfaceImplementations.put(AccountService.class, AccountServiceImpl.class);
    interfaceImplementations.put(AuthenticationManager.class, AuthenticationManagerImpl.class);
    interfaceImplementations.put(LogService.class, LogServiceImpl.class);
    if (interfaceClazz.isInterface()) {
      if (!interfaceImplementations.containsKey(interfaceClazz)) {
        throw new RuntimeException(
            String.format("Can't find implementation of %s in map", interfaceClazz.getName()));
      }
      return interfaceImplementations.get(interfaceClazz);
    }
    return interfaceClazz;
  }
}
