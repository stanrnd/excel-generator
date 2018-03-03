package com.stanslab.excel;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.TypePath;

public class ExcelAnnotationVisitor extends ClassVisitor {

	public ExcelAnnotationVisitor() {
		super(Opcodes.ASM6);
	}
	
    public void visit(int version, int access, String name, String signature,
            String superName, String[] interfaces) {
        if (cv != null) {
            cv.visit(version, access, name, signature, superName, interfaces);
        }
        System.out.println("visit: " + name + " - " + signature + " - " + superName + " - " + interfaces);
    }

    public void visitSource(String source, String debug) {
        if (cv != null) {
            cv.visitSource(source, debug);
        }
        System.out.println("visitSource: " + source + " - " + debug);
    }
    
    public ModuleVisitor visitModule(String name, int access, String version) {
        if (api < Opcodes.ASM6) {
            throw new RuntimeException();
        }
        if (cv != null) {
            return cv.visitModule(name, access, version);
        }
        System.out.println("visitModule: " + name + " - " + version);
        return null;
    }

    public void visitOuterClass(String owner, String name, String desc) {
        if (cv != null) {
            cv.visitOuterClass(owner, name, desc);
        }
        System.out.println("visitOuterClass: " + name + " - " + owner + " - " + desc);
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        if (cv != null) {
            return cv.visitAnnotation(desc, visible);
        }
        System.out.println("visitAnnotation: " + desc + " - " + visible);
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef,
            TypePath typePath, String desc, boolean visible) {
        if (api < Opcodes.ASM5) {
            throw new RuntimeException();
        }
        if (cv != null) {
            return cv.visitTypeAnnotation(typeRef, typePath, desc, visible);
        }
        System.out.println("visitTypeAnnotation: " + desc + " - " + typeRef + " - " + typePath + " - " + visible);
        return null;
    }

    public void visitAttribute(Attribute attr) {
        if (cv != null) {
            cv.visitAttribute(attr);
        }
        System.out.println("visitAttribute: " + attr);
    }

    public void visitInnerClass(String name, String outerName,
            String innerName, int access) {
        if (cv != null) {
            cv.visitInnerClass(name, outerName, innerName, access);
        }
        System.out.println("visitInnerClass: " + name + " - " + outerName + " - " + innerName + " - " + access);
    }

    public FieldVisitor visitField(int access, String name, String desc,
            String signature, Object value) {
        if (cv != null) {
            return cv.visitField(access, name, desc, signature, value);
        }
        System.out.println("visitField: " + name + " - " + desc + " - " + signature + " - " + access);
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String desc,
            String signature, String[] exceptions) {
        if (cv != null) {
            return cv.visitMethod(access, name, desc, signature, exceptions);
        }
        System.out.println("visitMethod: " + name + " - " + desc + " - " + signature + " - " + access + " - " + exceptions);
        return null;
    }

    public void visitEnd() {
        if (cv != null) {
            cv.visitEnd();
        }
        System.out.println("visitEnd: ");
    }


}
