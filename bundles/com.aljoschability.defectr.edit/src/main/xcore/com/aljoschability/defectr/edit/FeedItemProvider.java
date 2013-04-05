/**
 * <copyright>
 * 
 * Copyright 2013 by Aljoschability and others. All rights reserved.
 * 
 * This program and its materials are made available under the terms of the
 * Eclipse Public License v1.0 which should be contained in this distribution.
 * 
 * Contributors:
 *    Aljoscha Hark <aljoschability@gmail.com> - Initial code
 * 
 * </copyright>
 */
package com.aljoschability.defectr.edit;

import com.aljoschability.defectr.DefectrFactory;
import com.aljoschability.defectr.DefectrPackage;
import com.aljoschability.defectr.Feed;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.aljoschability.defectr.Feed} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeedItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeedItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTitlePropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addEditorPropertyDescriptor(object);
			addWebmasterPropertyDescriptor(object);
			addUpdateIntervalPropertyDescriptor(object);
			addLastBuildDatePropertyDescriptor(object);
			addLanguagePropertyDescriptor(object);
			addCopyrightPropertyDescriptor(object);
			addGeneratorPropertyDescriptor(object);
			addContainersPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Title feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTitlePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feed_title_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Feed_title_feature", "_UI_Feed_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				DefectrPackage.Literals.FEED__TITLE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feed_description_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Feed_description_feature", "_UI_Feed_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				DefectrPackage.Literals.FEED__DESCRIPTION, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Editor feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEditorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Feed_editor_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Feed_editor_feature", "_UI_Feed_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				DefectrPackage.Literals.FEED__EDITOR, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Webmaster feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWebmasterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Feed_webmaster_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Feed_webmaster_feature", "_UI_Feed_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				DefectrPackage.Literals.FEED__WEBMASTER, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Update Interval feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUpdateIntervalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feed_updateInterval_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Feed_updateInterval_feature", "_UI_Feed_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				DefectrPackage.Literals.FEED__UPDATE_INTERVAL, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Last Build Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastBuildDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feed_lastBuildDate_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Feed_lastBuildDate_feature", "_UI_Feed_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				DefectrPackage.Literals.FEED__LAST_BUILD_DATE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Language feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feed_language_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Feed_language_feature", "_UI_Feed_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				DefectrPackage.Literals.FEED__LANGUAGE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				null, null));
	}

	/**
	 * This adds a property descriptor for the Copyright feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCopyrightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feed_copyright_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Feed_copyright_feature", "_UI_Feed_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				DefectrPackage.Literals.FEED__COPYRIGHT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Generator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGeneratorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_Feed_generator_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Feed_generator_feature", "_UI_Feed_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				DefectrPackage.Literals.FEED__GENERATOR, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Containers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Feed_containers_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Feed_containers_feature", "_UI_Feed_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				DefectrPackage.Literals.FEED__CONTAINERS, true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DefectrPackage.Literals.FEED__LINK);
			childrenFeatures.add(DefectrPackage.Literals.FEED__EPISODES);
			childrenFeatures.add(DefectrPackage.Literals.FEED__IMAGE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Feed.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Feed")); //$NON-NLS-1$
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Feed) object).getTitle();
		return label == null || label.length() == 0 ? getString("_UI_Feed_type") : //$NON-NLS-1$
				getString("_UI_Feed_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Feed.class)) {
		case DefectrPackage.FEED__TITLE:
		case DefectrPackage.FEED__DESCRIPTION:
		case DefectrPackage.FEED__UPDATE_INTERVAL:
		case DefectrPackage.FEED__LAST_BUILD_DATE:
		case DefectrPackage.FEED__LANGUAGE:
		case DefectrPackage.FEED__COPYRIGHT:
		case DefectrPackage.FEED__GENERATOR:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case DefectrPackage.FEED__LINK:
		case DefectrPackage.FEED__EPISODES:
		case DefectrPackage.FEED__IMAGE:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(DefectrPackage.Literals.FEED__LINK,
				DefectrFactory.eINSTANCE.createLink()));

		newChildDescriptors.add(createChildParameter(DefectrPackage.Literals.FEED__LINK,
				DefectrFactory.eINSTANCE.createMediaLink()));

		newChildDescriptors.add(createChildParameter(DefectrPackage.Literals.FEED__EPISODES,
				DefectrFactory.eINSTANCE.createEpisode()));

		newChildDescriptors.add(createChildParameter(DefectrPackage.Literals.FEED__IMAGE,
				DefectrFactory.eINSTANCE.createFeedImage()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Activator.INSTANCE;
	}

}
