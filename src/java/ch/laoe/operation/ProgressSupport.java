/*
 * Copyright (c) 2001 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package ch.laoe.operation;

import java.io.Serializable;

import javax.swing.event.EventListenerList;


/**
 * Editor �@�\�̂̊�{�����N���X�ł��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 010820 nsano initial version <br>
 *          0.10 020503 nsano use EventListenerList <br>
 *          0.11 020503 nsano repackage <br>
 *          0.12 020510 nsano repackage <br>
 *          0.20 020510 nsano deprecate open/close <br>
 */
public class ProgressSupport implements Serializable {

    /** The editor listeners */
    private EventListenerList listenerList = new EventListenerList();

    /** EditorListener ��ǉ����܂��D */
    public void addEditorListener(ProgressListener l) {
        listenerList.add(ProgressListener.class, l);
    }

    /** EditorListener ���폜���܂��D */
    public void removeEditorListener(ProgressListener l) {
        listenerList.remove(ProgressListener.class, l);
    }

    /** �G�f�B�^���I�[�v�����ꂽ�C�x���g�𔭍s���܂��D */
    public void entrySubProgress(ProgressEvent ev) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ProgressListener.class) {
                ((ProgressListener) listeners[i + 1]).entrySubProgress(ev);
            }
        }
    }

    /** �G�f�B�^���A�b�v�f�[�g���ꂽ�C�x���g�𔭍s���܂��D */
    public void setProgress(ProgressEvent ev) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ProgressListener.class) {
                ((ProgressListener) listeners[i + 1]).setProgress(ev);
            }
        }
    }

    /** �G�f�B�^���N���[�Y���ꂽ�C�x���g�𔭍s���܂��D */
    public void exitSubProgress(ProgressEvent ev) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ProgressListener.class) {
                ((ProgressListener) listeners[i + 1]).exitSubProgress(ev);
            }
        }
    }
}

/* */
