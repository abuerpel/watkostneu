

import java.io.File;
import java.net.URL;

/** liefert die Position des .jar-Archives in dem sich eine Klasse befindet.
 *
 * @author nigjo
 */
public class JarSearcher
{
  private Class searchClass;

  public JarSearcher()
  {
  }

  public static File getJar(Object obj)
  {
    JarSearcher searcher = new JarSearcher();

    searcher.setClass(obj.getClass());

    return searcher.findJar();
  }

  /** liefert das File-Objekt der .jar-Datei.
   *
   * @return <code>null</code> wenn Klasse nicht in einer .jar-Datei ist
   */
  private File findJar()
  {
    String klasse = getClassURL().getFile();

    if (klasse.indexOf(".jar!") >= 0)
    {
      String jar = klasse.substring(0, klasse.indexOf(".jar!") + 4);

      return new File(jar);
    }

    // keine jar-Datei gefunden.
    return null;
  }

  private URL getClassURL()
  {
    String name = searchClass.getName();

    name = name.replaceAll("\\.", "/");

    return searchClass.getClassLoader().getResource(name + ".class");
  }

  private void setClass(Class toSearch)
  {
    searchClass = toSearch;
  }

  /** liefert das Verzeichnis der jar-Datei, in dem sich die Klasse zum
   *  angegebenen Objekt befindet.
   *
   * @param obj
   * @return <code>null</code> wenn Klasse nicht in einer .jar-Datei ist.
   */
  public static File getJarDirectory(Object obj)
  {
    // suche Jar-Datei
    File jar = getJar(obj);
    if (jar != null)
    {
      // jar-Datei gefunden.
      return jar.getParentFile();
    }
    // jar-Datei nicht gefunden
    return null;
  }
}
