package com.braunster.chatsdk.dao;

import java.util.List;
import com.braunster.chatsdk.dao.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import java.util.List;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.braunster.chatsdk.dao.DaoSession;
import com.braunster.chatsdk.firebase.BPath;
// KEEP INCLUDES END
/**
 * Entity mapped to table BTHREAD.
 */
public class BThread extends Entity<BThread>  {

    private String entityID;
    private java.util.Date creationDate;
    private Boolean dirty;
    private Boolean hasUnreadMessages;
    private String name;
    private Integer type;
    private String creator;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient BThreadDao myDao;

    private BUser bUser;
    private String bUser__resolvedKey;

    private List<BMessage> messages;
    private List<BLinkData> users;

    // KEEP FIELDS - put your custom fields here
    public enum Type{
        Private, Public// TODO check if in the right order.
    }
    // KEEP FIELDS END

    public BThread() {
    }

    public BThread(String entityID) {
        this.entityID = entityID;
    }

    public BThread(String entityID, java.util.Date creationDate, Boolean dirty, Boolean hasUnreadMessages, String name, Integer type, String creator) {
        this.entityID = entityID;
        this.creationDate = creationDate;
        this.dirty = dirty;
        this.hasUnreadMessages = hasUnreadMessages;
        this.name = name;
        this.type = type;
        this.creator = creator;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBThreadDao() : null;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public java.util.Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getDirty() {
        return dirty;
    }

    public void setDirty(Boolean dirty) {
        this.dirty = dirty;
    }

    public Boolean getHasUnreadMessages() {
        return hasUnreadMessages;
    }

    public void setHasUnreadMessages(Boolean hasUnreadMessages) {
        this.hasUnreadMessages = hasUnreadMessages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    /** To-one relationship, resolved on first access. */
    public BUser getBUser() {
        String __key = this.creator;
        if (bUser__resolvedKey == null || bUser__resolvedKey != __key) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BUserDao targetDao = daoSession.getBUserDao();
            BUser bUserNew = targetDao.load(__key);
            synchronized (this) {
                bUser = bUserNew;
            	bUser__resolvedKey = __key;
            }
        }
        return bUser;
    }

    public void setBUser(BUser bUser) {
        synchronized (this) {
            this.bUser = bUser;
            creator = bUser == null ? null : bUser.getEntityID();
            bUser__resolvedKey = creator;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<BMessage> getMessages() {
        if (messages == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BMessageDao targetDao = daoSession.getBMessageDao();
            List<BMessage> messagesNew = targetDao._queryBThread_Messages(entityID);
            synchronized (this) {
                if(messages == null) {
                    messages = messagesNew;
                }
            }
        }
        return messages;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetMessages() {
        messages = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<BLinkData> getUsers() {
        if (users == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BLinkDataDao targetDao = daoSession.getBLinkDataDao();
            List<BLinkData> usersNew = targetDao._queryBThread_Users(entityID);
            synchronized (this) {
                if(users == null) {
                    users = usersNew;
                }
            }
        }
        return users;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetUsers() {
        users = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    @Override
    public void updateFrom(BThread bThread) {

    }

    @Override
    public BPath getPath() {
        return null;
    }

    @Override
    public Entity.Type getEntityType() {
        return null;
    }

    @Override
    public void updateFromMap(Map<String, Object> map) {

    }

    @Override
    public Map<String, Object> asMap() {
        return null;
    }

    @Override
    public Object getPriority() {
        return null;
    }

    @Override
    public Date lastUpdated() {
        return null;
    }
    // KEEP METHODS END

}