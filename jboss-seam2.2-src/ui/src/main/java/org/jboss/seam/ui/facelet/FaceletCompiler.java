package org.jboss.seam.ui.facelet;


import static org.jboss.seam.ScopeType.APPLICATION;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Unwrap;
import org.jboss.seam.annotations.intercept.BypassInterceptors;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.log.LogProvider;
import org.jboss.seam.log.Logging;

import com.sun.faces.application.ApplicationAssociate;
import com.sun.faces.facelets.compiler.Compiler;
import com.sun.faces.facelets.compiler.SAXCompiler;
import javax.faces.view.facelets.TagDecorator;
import com.sun.faces.facelets.tag.TagLibrary;
import com.sun.faces.facelets.tag.TagLibraryImpl;
import com.sun.faces.facelets.util.ReflectionUtil;

@Name("org.jboss.seam.ui.facelet.faceletCompiler")
@Scope(APPLICATION)
@BypassInterceptors
@AutoCreate
@Install(value = true, precedence = Install.BUILT_IN, classDependencies="com.sun.faces.facelets.Facelet")
public class FaceletCompiler
{
   
  // private LogProvider log = Logging.getLogProvider(FaceletCompiler.class);
   private Compiler compiler;
   
   @Create
   public void create()
   {
      //compiler = new SAXCompiler();
     // fill the necessary parameters 
     // initializeCompiler(compiler);
      compiler = ApplicationAssociate.getCurrentInstance().getCompiler();
   }
   
   /*
    * This method cribbed from FaceletViewHandler 
    */
   /*protected void initializeCompiler(Compiler compiler) 
   {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      ExternalContext externalContext = facesContext.getExternalContext();

      // load libraries
      String libraryParameter = externalContext.getInitParameter("facelets.LIBRARIES");
      if (libraryParameter != null) 
      {
         libraryParameter = libraryParameter.trim();
         String[] libraries = libraryParameter.split(";");
         URL src;
         TagLibrary libraryObject;
         for (int i = 0; i < libraries.length; i++) 
         {
            try
            {
               src = externalContext.getResource(libraries[i].trim());
               if (src == null) 
               {
                  throw new FileNotFoundException(libraries[i]);
               }
               //libraryObject = TagLibraryConfig.create(src);
               libraryObject = new TagLibraryImpl(libraries[i].trim());
               compiler.addTagLibrary(libraryObject);
               log.trace("Successfully Loaded Library: " + libraries[i]);
            }
            catch (IOException e) 
            {
               log.error("Error Loading Library: " + libraries[i], e);
            }
         }
      }

      // load decorators
      String decoratorParameter = externalContext.getInitParameter("facelets.DECORATORS");
      if (decoratorParameter != null) 
      {
         decoratorParameter = decoratorParameter.trim();
         String[] decorators = decoratorParameter.split(";");
         TagDecorator decoratorObject;
         for (int i = 0; i < decorators.length; i++) 
         {
            try 
            {
               decoratorObject = (TagDecorator) ReflectionUtil.forName(decorators[i]).newInstance();
               compiler.addTagDecorator(decoratorObject);
               log.trace("Successfully Loaded Decorator: " + decorators[i]);
            } 
            catch (Exception e) 
            {
               log.error("Error Loading Decorator: " + decorators[i], e);
            }
         }
      }

      // skip params?
      String skipParameters = externalContext.getInitParameter("facelets.SKIP_COMMENTS");
      if (skipParameters != null && "true".equals(skipParameters)) 
      {
         compiler.setTrimmingComments(true);
      }
   }*/
   
   @Unwrap
   public Compiler unwrap()
   {
      return compiler;
   }
   
   public static Compiler instance()
   {
      if ( !Contexts.isApplicationContextActive() )
      {
         throw new IllegalStateException("No active application scope");
      }
      return (Compiler) Component.getInstance(FaceletCompiler.class, ScopeType.APPLICATION);
   }
   
}
